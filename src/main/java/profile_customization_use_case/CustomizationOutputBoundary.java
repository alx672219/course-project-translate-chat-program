package profile_customization_use_case;

public interface CustomizationOutputBoundary {

    CustomizationResponse prepareSuccessView(CustomizationResponse response);

    CustomizationResponse prepareFailView(String error);
}
