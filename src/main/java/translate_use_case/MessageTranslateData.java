package translate_use_case;

public class MessageTranslateData {
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
