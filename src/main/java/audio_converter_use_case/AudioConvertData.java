package audio_converter_use_case;

public class AudioConvertData {
    /**
     * Data class containing a filePath, the path where the audio file is located
     * languageCode contains the language that specifies what language the audio is spoken in
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
