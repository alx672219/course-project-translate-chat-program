package translate_use_case;

import java.io.IOException;

public interface MessageTranslateInputBoundary {
    /**
     * @param data
     *      contains original text, target language, and source language
     * @return
     *      return a response containing the translated text
     */

    MessageTranslateResponse translate(MessageTranslateData data) throws IOException;
}
