package translate_use_case;

import java.io.IOException;

public interface MessageTranslateGateway {
    /**
     * @param messageTranslateData the MessageTrasnlateData needed to execute this method
     * @return translate String, the translated text
     */
    String translate(MessageTranslateData messageTranslateData) throws IOException;

}
