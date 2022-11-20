package audio_converter_use_case;

public class AudioConvertData {
    /**
     * @param filePath String, the audio file being converted
     * @param languageCode, the language of the audio file
     */
    private final String filePath;
    private final String languageCode;

    public String getFilePath() {
        return filePath;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public AudioConvertData(String filePath, String languageCode){
        this.filePath = filePath;
        this.languageCode = languageCode;
    }
}
