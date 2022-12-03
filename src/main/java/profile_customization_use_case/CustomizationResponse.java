package profile_customization_use_case;

import shared.Response;

public class CustomizationResponse extends Response {

    private final String name;
    private final String default_language;
    private final int uid;
    private final String password;

    /**
     * Constructor for CustomizationResponse
     *
     * @param name             the name that was changed
     * @param default_language the language that was changed
     * @param password         the password that was changed
     * @param success          if the change was successful
     * @param e                throw exception if change failed
     * @param uid              the id of the user who was affected
     */
    public CustomizationResponse(String name, String default_language, String password, boolean success, Exception e, int uid) {
        this.name = name;
        this.default_language = default_language;
        this.password = password;
        this.uid = uid;
        this.success = success;
        this.e = e;
    }

    /**
     * Getter method for name
     * @return the name attribute
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method for the default language
     * @return the default language attribute
     */
    public String getDefaultLanguage() {
        return this.default_language;
    }

    /**
     * Getter method for the password
     * @return the password attribute
     */
    public String getPassword() {
        return this.password;
    }

    public int getUid() {return this.uid;}

    /**
     * Getter method for the exception
     * @return the exception attribute
     */
    @Override
    public Exception getException() {
        return super.e;
    }
}
