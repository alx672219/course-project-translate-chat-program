package profile_customization_use_case;

public class CustomizationPresenter implements CustomizationOutputBoundary{

    @Override
    public UpdateResponse prepareSuccessView(UpdateResponse response) {
        return response;
    }

    public UpdateResponse prepareFailView(String error) {
        throw new CustomizationFailed(error);
    }
}
