package profile_customization_use_case;

import entities.User;

public class CustomizationData {

    private String name;
    private String default_lang;
    private String password;
    private User user;

    /**
     * Constructor for CustomizationData
     * @param name the new name to change to
     * @param default_lang the new default language to change to
     * @param password the new password to change to
     * @param user the user whose attributes will be changed
     */
    public CustomizationData(String name, String default_lang, String password, User user) {
        this.name = name;
        this.default_lang = default_lang;
        this.password = password;
        this.user = user;
    }

    /**
     * Getter method for the new name
     * @return new name to change to
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the new default language
     * @return new default language to change to
     */
    public String getDefaultLang() {
        return default_lang;
    }

    /**
     * Getter method for the new password
     * @return new password to change to
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter method for the user
     * @return the user whose attributes will be changed
     */
    public User getUser() {
        return user;
    }
}
