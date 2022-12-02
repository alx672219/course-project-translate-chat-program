package audio_converter_use_case;

import gateways.AudioConvertGoogleCloud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioConvertInteractorTest {
    AudioConvertGoogleCloud gateway;
    AudioConvertInteractor interactor;
    AudioConvertPresenter presenter;
    String keyPath;

    @BeforeEach
    void setUp() throws IOException {
        this.keyPath = "speech-key.json";
        this.gateway = new AudioConvertGoogleCloud(keyPath);
        this.presenter = new AudioConvertPresenter();
        this.interactor = new AudioConvertInteractor(gateway, presenter);
    }

    @Test
    void AudioConvertEnglish(){
        AudioConvertData data = new AudioConvertData(
                "src/test/java/test_files/convTestEN.wav",
                "en-US"
        );
        AudioConvertResponse actualResponse = interactor.convert(data);
        assertEquals("hello hello 1 2 3", actualResponse.getResult());
    }
}
