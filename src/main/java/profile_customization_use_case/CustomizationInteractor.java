package profile_customization_use_case;

import entities.User;

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
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null);

        gateway.updateDefaultLang(data.getUser(), data.getDefaultLang());
        return presenter.prepareSuccessView(response);
    }

    /**
     * Change name to the new name provided in data and return a response
     * @param data on what name to change to
     * @return CustomizationResponse class on what to display to user
     */
    @Override
    public CustomizationResponse changeName(CustomizationData data) {
        // Update the database such that the user's "name" field is updated
        User updatedUser = new User(data.getName(), data.getUser().getDefault_lang(), data.getUser().getEmail(),
                data.getUser().getPassword(), data.getUser().getUser_id());
        if (data.getName().isBlank()) {
            return presenter.prepareFailView("Please enter a name");
        } else if (gateway.existName(updatedUser)) {
            return presenter.prepareFailView("Name already taken, please enter another name");
        }

        String default_lang = data.getDefaultLang();
        String name = data.getName();
        String password = data.getPassword();
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null);

        gateway.updateName(data.getUser(), data.getName());
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
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null);


        gateway.updatePassword(data.getUser(), data.getPassword());
        return presenter.prepareSuccessView(response);
    }
}
