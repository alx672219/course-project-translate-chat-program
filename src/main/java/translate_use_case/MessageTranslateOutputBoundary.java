package translate_use_case;

public interface MessageTranslateOutputBoundary {
    MessageTranslateResponse prepareSuccessView(MessageTranslateResponse response);
    MessageTranslateResponse prepareFailView(String error);
}
