package translate_use_case;

import gateways.MessageTranslateGoogleCloud;

import java.io.IOException;

public class MessageTranslateTest {
    public static void main(String[] args) throws IOException {


        MessageTranslateGoogleCloud MT = new MessageTranslateGoogleCloud("speech-key.json");
        System.out.println(MT.translate(new MessageTranslateData("das ist nicht englisch", "en", "de")));
    }
}
