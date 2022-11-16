package atranslate_use_case;

import java.io.IOException;

public class TranslatorController {
    String original;
    String result;

    public String getOriginal(){
        return original;
    }
    public void setOriginal(String original){
        this.original = original;
    }

    public String getResult() {
        return result;
    }
    private void setResult(String result){
        this.result = result;
    }


    public void translate(String languageCode) throws IOException {
        Translator T = new Translator("speech-key.json");
        setResult(T.Translate(getOriginal(), languageCode));
    }
}
