package audio_converter_use_case;

public class AudioConvertData {
    /**
     * @param filePath
     *      The string containing the path to the audio file
     * @param languageCode
     *      The language spoken in the audio file
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
