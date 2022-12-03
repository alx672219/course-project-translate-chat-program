package profile_customization_use_case;

import entities.User;

import java.util.concurrent.ExecutionException;

public interface CustomizationGateway {

    /**
     * Change user's default language in the database
     * @param uid the id of the user whose language will be changed
     * @param default_lang the new language to change to
     */
    void updateDefaultLang(int uid, String default_lang);

    /**
     * Change user's name in the database
     * @param uid the id of the user whose name will be changed
     * @param name the new name to change to
     */
    void updateName(int uid, String name);

    /**
     * Change user's password in the database
     * @param uid the id of the user whose password will be changed
     * @param password the new password to change to
     */
    void updatePassword(int uid, String password);

    /**
     * Check if the new chosen name already exists in the database
     * @param username the  name needs to be checked
     * @return the User with the given name if name exists
     */
    User getByUsername(String username) throws ExecutionException, InterruptedException;
}
