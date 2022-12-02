package translate_use_case;

import java.io.IOException;

public class MessageTranslateInteractor implements MessageTranslateInputBoundary{
    final MessageTranslateGateway gateway;
    final MessageTranslateOutputBoundary presenter;

    public MessageTranslateInteractor(MessageTranslateGateway gateway, MessageTranslatePresenter presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public MessageTranslateResponse translate(MessageTranslateData data) throws IOException {

        //Do failure cases

        String result = gateway.translate(data);
        MessageTranslateResponse response = new MessageTranslateResponse(
                result, true, null);
        return presenter.prepareSuccessView(response);
    }
}
