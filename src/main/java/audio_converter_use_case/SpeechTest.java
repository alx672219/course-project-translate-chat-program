package audio_converter_use_case;

public class SpeechTest {

    public static void main(String[] args) throws Exception{

        AudioConverterController AC = new AudioConverterController();
        AC.convertAudio("src/main/Others/RecordAudio2.wav", "en-US");
        System.out.println(AC.getResult());

    }
}
