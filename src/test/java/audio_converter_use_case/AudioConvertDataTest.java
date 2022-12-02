package audio_converter_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AudioConvertDataTest {

    private AudioConvertData dataEnglish;

    @BeforeEach
    void setUp() {
        this.dataEnglish = new AudioConvertData("test_files/convTestEN.wav", "en-US");
    }

    @Test
    void getFilePath() {
        assert(dataEnglish.getFilePath().equals("test_files/convTestEN.wav"));
    }

    @Test
    void getLanguageCode() {
        assert(dataEnglish.getLanguageCode().equals("en-US"));
    }

}