package profile_customization_use_case;

import java.util.concurrent.ExecutionException;

public interface CustomizationInputBoundary {
    CustomizationResponse changeLanguage(CustomizationData data);
    CustomizationResponse changeName(CustomizationData data);
    CustomizationResponse changePassword(CustomizationData data) throws ExecutionException, InterruptedException;
}
