package translate_use_case;

import shared.Response;

public class MessageTranslateResponse extends Response {
    /**
     * Response class containing
     * original, the original untranslated text
     * targetLanguage, the language to be translated into
     * sourceLanguage, the original language of the untranslated text
     * result, the translated text
     */
    private String original;
    private String targetLanguage;
    private String sourceLanguage;
    private String result;

    public String getOriginal() {
        return original;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public String getResult() {
        return result;
    }
    @Override
    public Exception getException() {
        return e;
    }

    public MessageTranslateResponse(String original, String targetLanguage, String sourceLanguage,
                                    String result, boolean success, Exception e) {

        this.original = original;
        this.targetLanguage = targetLanguage;
        this.sourceLanguage = sourceLanguage;
        this.result = result;
        this.success = success;
        this.e = e;
    }
}
