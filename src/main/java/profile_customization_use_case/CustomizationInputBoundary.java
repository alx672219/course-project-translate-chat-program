package profile_customization_use_case;

public interface CustomizationInputBoundary {
    void changeLanguage(CustomizationData data);
    void changeName(CustomizationData data);
    void changePassword(CustomizationData data);
}
