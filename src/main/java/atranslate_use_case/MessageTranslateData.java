package atranslate_use_case;

public class MessageTranslateData {
    /**
     * @param original String, original text
     * @param targetLanguage String, the language to be translated into
     * @param sourceLangauge String, the language of original text
     */
    private final String original;
    private final String targetLanguage;
    private final String sourceLanguage;

    public String getOriginal() {
        return original;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public MessageTranslateData(String original, String targetLanguage, String sourceLanguage){
        this.original = original;
        this.targetLanguage = targetLanguage;
        this.sourceLanguage = sourceLanguage;
    }
}
