package gateways;

import entities.User;
import profile_customization_use_case.CustomizationGateway;
import services.DBService;

import java.util.concurrent.ExecutionException;

public class CustomizationFirebaseSystem implements CustomizationGateway {
    DBService dbService;

    /**
     * Constructor for CustomizationFirebaseSystem
     */
    public CustomizationFirebaseSystem() {
        this.dbService = DBService.getInstance();
    }

    /**
     * Change user's default language in the database
     * @param uid the id of the user whose language will be changed
     * @param default_lang the new language to change to
     */
    @Override
    public void updateDefaultLang(int uid, String default_lang) {
        dbService.updateDefaultLang(uid, default_lang);
    }

    /**
     * Change user's name in the database
     * @param uid the id of the  user whose name will be changed
     * @param name the new name to change to
     */
    @Override
    public void updateName(int uid, String name) {
        dbService.updateName(uid, name);
    }

    /**
     * Change user's password in the database
     * @param uid the id of the user whose password will be changed
     * @param password the new password to change to
     */
    @Override
    public void updatePassword(int uid, String password) {
        dbService.updatePassword(uid, password);
    }

    /**
     * Check if user's new name already exists in the database
     * @param username the user's whose name new name needs to be checked
     * @return the user with the given name if it exists and null otherwise
     */
    @Override
    public User getByUsername(String username) throws ExecutionException, InterruptedException {
        return dbService.getByUsername(username);
    }
}
