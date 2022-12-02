package gateways;

import entities.User;
import profile_customization_use_case.CustomizationGateway;
import services.DBService;

public class CustomizationFirebaseSystem implements CustomizationGateway {
    DBService dbService;

    /**
     * Constructor for CustomizationFirebaseSystem
     */
    public CustomizationFirebaseSystem() {
        this.dbService = new DBService();
    }

    /**
     * Change user's default language in the database
     * @param user the user whose language will be changed
     * @param default_lang the new language to change to
     */
    @Override
    public void updateDefaultLang(User user, String default_lang) {
        dbService.updateDefaultLang(user, default_lang);
    }

    /**
     * Change user's name in the database
     * @param user the user whose name will be changed
     * @param name the new name to change to
     */
    @Override
    public void updateName(User user, String name) {
        dbService.updateName(user, name);
    }

    /**
     * Change user's password in the database
     * @param user the user whose password will be changed
     * @param password the new password to change to
     */
    @Override
    public void updatePassword(User user, String password) {
        dbService.updatePassword(user, password);
    }

    /**
     * Check if user's new name already exists in the database
     * @param user the user's whose name new name needs to be checked
     * @return true if the new name exist and false otherwise
     */
    @Override
    public boolean existName(User user) {
        return dbService.existName(user);
    }
}
