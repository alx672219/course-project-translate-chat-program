package atranslate_use_case;

import audio_converter_use_case.AudioConverter;

import java.io.IOException;

public class MessageTest {
    public static void main(String[] args) throws IOException {
        TranslatorController T = new TranslatorController();
        T.setOriginal("Hello, this sentence is a test string.");
        T.translate("fr");
        System.out.println(T.getResult());
    }
}
