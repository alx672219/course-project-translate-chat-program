package atranslate_use_case;

import java.io.IOException;

public class MessageTranslateInteractor implements MessageTranslateInputBoundary{
    final MessageTranslateGateway gateway;
    final MessageTranslateOutputBoundary presenter;

    public MessageTranslateInteractor(MessageTranslateGateway gateway, MessageTranslatePresenter presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public MessageTranslateResponse convert(MessageTranslateData data) throws IOException {

        //Do failure cases

        String result = gateway.translate(data);
        MessageTranslateResponse response = new MessageTranslateResponse(data.getOriginal(), data.getTargetLanguage(), data.getSourceLanguage(),
                result, true, null);
        return presenter.prepareSuccessView(response);
    }
}
