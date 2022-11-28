package translate_use_case;

import java.io.IOException;

public interface MessageTranslateGateway {
    /**
     *
     * @param messageTranslateData
     *      a data bundle containing a string, the language to be translated to, and the original language
     * @return
     *      return a string with the original string translated from sourceLanguage to targetLangauge
     * @throws IOException
     */

    String translate(MessageTranslateData messageTranslateData) throws IOException;

}
