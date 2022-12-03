package profile_customization_use_case;

import entities.User;

import java.util.concurrent.ExecutionException;

public class CustomizationInteractor implements CustomizationInputBoundary{

    CustomizationGateway gateway;
    CustomizationOutputBoundary presenter;

    /**
     * Constructor for CustomizationInteractor
     * @param gateway to access database
     * @param presenter to inform UI what to show
     */
    public CustomizationInteractor(CustomizationGateway gateway, CustomizationOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     *Change language to the new language provided in data and return a response
     * @param data on what language to change to
     * @return CustomizationResponse class on what to display to user
     */
    @Override
    public CustomizationResponse changeLanguage(CustomizationData data) {
        // Update the database such that the user's "default_lang" field is updated
        if (data.getDefaultLang().isBlank()) {
            return presenter.prepareFailView("Please enter a language");
        }

        String default_lang = data.getDefaultLang();
        String name = data.getName();
        String password = data.getPassword();
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null, data.getUser().getUserId());

        try {
            User user = gateway.getByUsername(data.getUser().getUsername());
            user.setDefault_lang(default_lang);
            gateway.updateDefaultLang(data.getUser().getUserId(), default_lang);
        } catch (ExecutionException | InterruptedException e) {
            throw new CustomizationFailed("Could not find user");
        }

        return presenter.prepareSuccessView(response);
    }

    /**
     * Change name to the new name provided in data and return a response
     * @param data on what name to change to
     * @return CustomizationResponse class on what to display to user
     */
    @Override
    public CustomizationResponse changeName(CustomizationData data) {
        // Check that the new name is not blank
        if (data.getName().isBlank()) {
            return presenter.prepareFailView("Please enter a name");
        } else {
            try {
                // Check to see if the new username is already in use
                User userWithNewName = gateway.getByUsername(data.getName());
                if (userWithNewName != null) {
                    return presenter.prepareFailView("Name already taken, please enter another name");
                }
                User user = gateway.getByUsername(data.getUser().getUsername());
                if (user == null) {
                    return presenter.prepareFailView("Something went wrong");
                }
                gateway.updateName(data.getUser().getUserId(), data.getName());
                user.setName(data.getName());
            } catch (ExecutionException | InterruptedException e) {
                // If the database cannot be accessed return this generic error message
                return presenter.prepareFailView("Something went wrong.");
            }
        }

        String default_lang = data.getDefaultLang();
        String name = data.getName();
        String password = data.getPassword();
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null, data.getUser().getUserId());

        return presenter.prepareSuccessView(response);
    }

    /**
     * Change password to the new password provided in data and return a response
     * @param data on what password to change to
     * @return CustomizationResponse class on what to display to user
     */
    @Override
    public CustomizationResponse changePassword(CustomizationData data) {
        // Update the database such that the user's "password" field is updated
        if (data.getPassword().isBlank()) {
            return presenter.prepareFailView("Please enter a password");
        } else if (data.getPassword().length() < 7) {
            return presenter.prepareFailView("Please enter a password longer than 7 characters");
        }

        String default_lang = data.getDefaultLang();
        String name = data.getName();
        String password = data.getPassword();

        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null, data.getUser().getUserId());

        try {
            User user = gateway.getByUsername(data.getUser().getUsername());
            user.setPassword(password);
            gateway.updatePassword(user.getUser_id(), data.getPassword());
        } catch (ExecutionException | InterruptedException e) {
            return presenter.prepareFailView("Could not find user");
        }
        return presenter.prepareSuccessView(response);
    }
}
