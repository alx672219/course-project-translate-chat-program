package audio_converter_use_case;

import gateways.AudioConvertGoogleCloud;

import java.io.IOException;

public class AudioConvertTest {

    public static void main(String[] args) throws IOException {


        AudioConvertGoogleCloud AC = new AudioConvertGoogleCloud("speech-key.json");
        System.out.println(AC.convert(new AudioConvertData("src/main/Others/RecordAudio2.wav", "en")));



    }

}
