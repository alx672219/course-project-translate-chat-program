package translate_use_case;

public interface MessageTranslateOutputBoundary {
    /**
     * Prepares the scenario in which the translating process is successful
     * @param response
     *      contains new translated string
     */
    MessageTranslateResponse prepareSuccessView(MessageTranslateResponse response);
    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    MessageTranslateResponse prepareFailView(String error);
}
