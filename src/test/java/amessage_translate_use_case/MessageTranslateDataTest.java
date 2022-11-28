package amessage_translate_use_case;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import translate_use_case.MessageTranslateData;

public class MessageTranslateDataTest {

    private MessageTranslateData dataEnglish;

    @BeforeEach
    void setUp() {
        this.dataEnglish = new MessageTranslateData("Hello hello one two three",
                "fr", "en-US");
    }

    @Test
    void getOriginal() {
        assert(dataEnglish.getOriginal().equals("Hello hello one two three"));
    }

    @Test
    void getTargetLanguage() {
        assert(dataEnglish.getTargetLanguage().equals("fr"));
    }

    @Test
    void getSourceLanguage() {
        assert(dataEnglish.getSourceLanguage().equals("en-US"));
    }
}
