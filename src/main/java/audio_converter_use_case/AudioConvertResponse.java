package audio_converter_use_case;

import shared.Response;

public class AudioConvertResponse extends Response {
    /**
     * Response class containing a filePath, language, and resulting string.
     * This is created when audio is successfully converted into text, which is then stored in the
     * result string.
     */

    private String filePath;
    private String languageCode;
    private String result;

    public AudioConvertResponse(String filePath, String languageCode, String result, boolean success, Exception e) {
        this.filePath = filePath;
        this.languageCode = languageCode;
        this.result = result;
        this.success = success;
        this.e = e;
    }
    public String getFilePath(){return filePath;}
    public String getLanguageCode(){return languageCode;}
    public String getResult(){return result;}
    public Exception getException() {return super.e;}

}
