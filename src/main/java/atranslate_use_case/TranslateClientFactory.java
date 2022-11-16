package atranslate_use_case;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
public class TranslateClientFactory {
    public Translate createTranslate(String keyPath){
        Translate translate = TranslateOptions.newBuilder().setApiKey(keyPath).build().getService();

        return translate;
    }
}
