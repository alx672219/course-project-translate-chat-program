package views;

import entities.User;
import profile_customization_use_case.CustomizationData;
import profile_customization_use_case.CustomizationInputBoundary;
import profile_customization_use_case.CustomizationResponse;

public class CustomizationController {
    private final CustomizationInputBoundary cib;

    /**
     * Constructor for CustomizationController
     * @param cib instance of CustomizationInputBoundary
     */
    public CustomizationController(CustomizationInputBoundary cib) {
        this.cib = cib;
    }

    /**
     * Calls the changeLanguage method from CustomizationInputBoundary
     * @param name the name attribute from CustomizationData
     * @param default_lang the default language attribute from CustomizationData
     * @param password the password attribute from CustomizationData
     * @param user the user attribute from CustomizationData
     * @return CustomizationResponse class that displays to the user
     */
    CustomizationResponse changeLanguage(String name, String default_lang, String password, User user) {
        CustomizationData data = new CustomizationData(name, default_lang, password, user);
        return this.cib.changeLanguage(data);
    }

    /**
     * Calls the changeName method from CustomizationInputBoundary
     * @param name the name attribute from CustomizationData
     * @param default_lang the default language attribute from CustomizationData
     * @param password the password attribute from CustomizationData
     * @param user the user attribute from CustomizationData
     * @return CustomizationResponse class that displays to the user
     */
    CustomizationResponse changeName(String name, String default_lang, String password, User user) {
        CustomizationData data = new CustomizationData(name, default_lang, password, user);
        return this.cib.changeName(data);
    }

    /**
     * Calls the changePassword method from CustomizationInputBoundary
     * @param name the name attribute from CustomizationData
     * @param default_lang the default language attribute from CustomizationData
     * @param password the password attribute from CustomizationData
     * @param user the user attribute from CustomizationData
     * @return CustomizationResponse class that displays to the user
     */
    CustomizationResponse changePassword(String name, String default_lang, String password, User user) {
        CustomizationData data = new CustomizationData(name, default_lang, password, user);
        return this.cib.changePassword(data);
    }
}