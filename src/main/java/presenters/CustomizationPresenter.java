package presenters;

import profile_customization_use_case.CustomizationFailed;
import profile_customization_use_case.CustomizationOutputBoundary;
import profile_customization_use_case.CustomizationResponse;

public class CustomizationPresenter implements CustomizationOutputBoundary {

    /**
     * Return given response when operation is successful
     * @param response the given response
     * @return the correct response
     */
    @Override
    public CustomizationResponse prepareSuccessView(CustomizationResponse response) {
        return response;
    }

    /**
     * Return error when operation failed
     * @param error the error message
     * @throws CustomizationFailed operation failed
     */
    public CustomizationResponse prepareFailView(String error) {
        throw new CustomizationFailed(error);
    }
}
