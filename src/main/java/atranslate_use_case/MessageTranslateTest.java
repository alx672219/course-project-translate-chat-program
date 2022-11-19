package atranslate_use_case;

import audio_converter_use_case.AudioConvertData;
import gateways.AudioConvertGoogleCloud;
import gateways.MessageTranslateGoogleCloud;

import java.io.IOException;

public class MessageTranslateTest {
    public static void main(String[] args) throws IOException {


        MessageTranslateGoogleCloud MT = new MessageTranslateGoogleCloud("speech-key.json");
        System.out.println(MT.translate(new MessageTranslateData("das ist nicht englisch", "en", "de")));
    }
}
