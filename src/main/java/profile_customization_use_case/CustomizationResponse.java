package profile_customization_use_case;

import shared.Response;

public class CustomizationResponse extends Response {

    private String name;
    private String default_language;
    private String password;

    /**
     * Constructor for CustomizationResponse
     * @param name the name that was changed
     * @param default_language the language that was changed
     * @param password the password that was changed
     * @param success if the change was successful
     * @param e throw exception if change failed
     */
    public CustomizationResponse(String name, String default_language, String password, boolean success, Exception e) {
        this.name = name;
        this.default_language = default_language;
        this.password = password;
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

    /**
     * Getter method for the exception
     * @return the exception attribute
     */
    @Override
    public Exception getException() {
        return super.e;
    }
}
