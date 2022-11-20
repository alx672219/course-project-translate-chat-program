package profile_customization_use_case;

public interface CustomizationInputBoundary {
    CustomizationResponse changeLanguage(CustomizationData data);
    CustomizationResponse changeName(CustomizationData data);
    CustomizationResponse changePassword(CustomizationData data);
}
