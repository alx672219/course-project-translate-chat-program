package profile_customization_use_case;

import shared.UserDetails;

public class CustomizationData {

    private final String name;
    private final String default_lang;
    private final String password;
    private final UserDetails user;

    /**
     * Constructor for CustomizationData
     * @param name the new name to change to
     * @param default_lang the new default language to change to
     * @param password the new password to change to
     * @param user the details of the user whose attributes will be changed
     */
    public CustomizationData(String name, String default_lang, String password, UserDetails user) {
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
     * Getter method for the user's details
     * @return the details of the user whose attributes will be changed
     */
    public UserDetails getUser() {
        return user;
    }
}
