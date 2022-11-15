package profile_customization_use_case;

import entities.User;

public class ChangeInfo implements CustomizationInputBoundary{

    @Override
    public void changeLanguage(User user, String language) {
        user.setDefaultLang(language);
    }

    @Override
    public void changeName(User user, String name) {
        user.setName(name);
    }

    @Override
    public void changePassword(User user, String password) {
        user.setPassword(password);
    }
}
