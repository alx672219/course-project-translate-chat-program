package profile_customization_use_case;

public interface CustomizationOutputBoundary {

    /**
     * When the operation is a success and return a response
     * @param response the given response
     * @return the correct response
     */
    CustomizationResponse prepareSuccessView(CustomizationResponse response);

    /**
     * When the operation is a fail and return a response
     * @param error the error message
     * @throws CustomizationFailed when operation fails
     */
    CustomizationResponse prepareFailView(String error);
}
