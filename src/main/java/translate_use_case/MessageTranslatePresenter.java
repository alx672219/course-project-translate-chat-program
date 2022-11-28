package translate_use_case;

public class MessageTranslatePresenter implements MessageTranslateOutputBoundary{
    /**
     * Prepares the scenario in which the translating process is successful
     * @param response
     *      contains new translated string
     */
    @Override
    public MessageTranslateResponse prepareSuccessView(MessageTranslateResponse response) {
        return response;
    }
    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    @Override
    public MessageTranslateResponse prepareFailView(String error) {
        throw new MessageTranslateFailed(error);
    }

}
