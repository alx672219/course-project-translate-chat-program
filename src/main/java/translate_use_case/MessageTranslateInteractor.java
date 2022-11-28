package translate_use_case;

import java.io.IOException;

public class MessageTranslateInteractor implements MessageTranslateInputBoundary{
    final MessageTranslateGateway gateway;
    final MessageTranslateOutputBoundary presenter;

    public MessageTranslateInteractor(MessageTranslateGateway gateway, MessageTranslatePresenter presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }
    /**
     * This method calls the gateway to take in data, and return a string containing
     * original string, translated into the target language
     *
     * @param data
     *      contains original text, target language, and source language
     * @return
     * MessageTranslateResponse, contains the original text, target language, source language
     * and the resulting translated string
     */
    @Override
    public MessageTranslateResponse translate(MessageTranslateData data){
        try {
            String result = gateway.translate(data);
            MessageTranslateResponse response = new MessageTranslateResponse(data.getOriginal(), data.getTargetLanguage(), data.getSourceLanguage(),
                    result, true, null);
            return presenter.prepareSuccessView(response);
        } catch (IOException e) {
            return presenter.prepareFailView(e.getMessage());
        }
    }
}
