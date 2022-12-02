package profile_customization_use_case;

import entities.User;

public interface CustomizationGateway {

    /**
     * Change user's default language in the database
     * @param user the user whose language will be changed
     * @param default_lang the new language to change to
     */
    void updateDefaultLang(User user, String default_lang);

    /**
     * Change user's name in the database
     * @param user the user whose name will be changed
     * @param name the new name to change to
     */
    void updateName(User user, String name);

    /**
     * Change user's password in the database
     * @param user the user whose password will be changed
     * @param password the new password to change to
     */
    void updatePassword(User user, String password);

    /**
     * Check if the new chosen name already exists in the database
     * @param user the user's whose name new name needs to be checked
     * @return true if name exist and false otherwise
     */
    boolean existName(User user);
}
