package profile_customization_use_case;

import entities.User;

public class CustomizationInteractor implements CustomizationInputBoundary{

    CustomizationGateway gateway;
    CustomizationOutputBoundary presenter;

    public CustomizationInteractor(CustomizationGateway gateway, CustomizationOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public CustomizationResponse changeLanguage(CustomizationData data) {
        // Update the database such that the user's "default_lang" field is updated
        if (data.getDefaultLang().isEmpty()) {
            return presenter.prepareFailView("Please enter a language");
        }

        String default_lang = data.getDefaultLang();
        String name = data.getName();
        String password = data.getPassword();
        CustomizationResponse response = new CustomizationResponse(name, default_lang, password, true, null);

        gateway.updateDefaultLang(data.getUser(), data.getDefaultLang());
        return presenter.prepareSuccessView(response);
    }

    @Override
    public CustomizationResponse changeName(CustomizationData data) {
        // Update the database such that the user's "name" field is updated
        User updatedUser = new User(data.getName(), data.getUser().getDefault_lang(), data.getUser().getEmail(),
                data.getUser().getPassword(), data.getUser().getUser_id());
        if (data.getName().isEmpty()) {
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

    @Override
    public CustomizationResponse changePassword(CustomizationData data) {
        // Update the database such that the user's "password" field is updated
        if (data.getPassword().isEmpty()) {
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
