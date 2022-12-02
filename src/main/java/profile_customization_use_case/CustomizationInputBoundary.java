package profile_customization_use_case;

public interface CustomizationInputBoundary {

    /**
     * Change the user's language and return a response
     * @param data containing the new language to change to
     * @return a response on what to display to user
     */
    CustomizationResponse changeLanguage(CustomizationData data);

    /**
     * Change user's name and return a response
     * @param data containing the new name to change to
     * @return a response on what to display to user
     */
    CustomizationResponse changeName(CustomizationData data);

    /**
     * Change user's password and return a response
     * @param data containing the new password to change to
     * @return a response on what to display to user
     */
    CustomizationResponse changePassword(CustomizationData data);
}
