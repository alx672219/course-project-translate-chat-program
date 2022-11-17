package profile_customization_use_case;

public interface CustomizationOutputBoundary {

    UpdateResponse prepareSuccessView(UpdateResponse response);

    UpdateResponse prepareFailView(String error);
}
