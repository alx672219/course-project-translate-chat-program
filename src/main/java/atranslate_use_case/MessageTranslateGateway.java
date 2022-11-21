package atranslate_use_case;

import java.io.IOException;

public interface MessageTranslateGateway {
    /**
     * @param original String, original text
     * @param targetLanguage String, the language to be translated into
     * @param sourceLangauge String, the language of original text
     * @return translate String, the translated text
     */

    String translate(MessageTranslateData messageTranslateData) throws IOException;

}
