package translate_use_case;

public class MessageTranslatePresenter implements MessageTranslateOutputBoundary{

    @Override
    public MessageTranslateResponse prepareSuccessView(MessageTranslateResponse response) {
        return response;
    }

    @Override
    public MessageTranslateResponse prepareFailView(String e) {
        throw new MessageTranslateFailed(e);
    }

}
