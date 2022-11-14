package profile_customization_use_case;

import entities.User;

public interface CustomizationInputBoundary {
    void changeLanguage(User user, String language);
    void changeName(User user, String name);
    void changePassword(User user, String password);
}
