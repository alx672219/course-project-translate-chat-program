package profile_customization_use_case;

import entities.User;

public class UserInteractor implements CustomizationInputBoundary{

    CustomizationGateway customizationGateway;

    public UserInteractor() {
        customizationGateway = new CustomizationGateway();
    }

    @Override
    public void changeLanguage(User user, String default_language) {
        // Update the database to make it such that the user's, "default_lang" field is updated
        customizationGateway.updateDefaultLang(user, default_language);
    }

    @Override
    public void changeName(User user, String name) {
        customizationGateway.updateName(user, name);
    }

    @Override
    public void changePassword(User user, String password) {
        customizationGateway.updatePassword(user, password);
    }
}
