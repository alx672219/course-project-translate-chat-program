package audio_converter_use_case;

import java.io.IOException;

public class AudioConverterController {
    String result;
    public String getResult() {
        return result;
    }

    public void setResult(String result){
        this.result = result;
    }

    public void convertAudio(String filePath, String languageCode) throws IOException {
        AudioConverter AC = new AudioConverter("speech-key.json");
        setResult(AC.convertToText(filePath, languageCode));
    }
}
