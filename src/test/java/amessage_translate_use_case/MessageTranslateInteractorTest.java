package amessage_translate_use_case;

import gateways.MessageTranslateGoogleCloud;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import translate_use_case.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTranslateInteractorTest
{
    MessageTranslateGateway gateway;
    MessageTranslateInteractor interactor;
    MessageTranslatePresenter presenter;

    String keyPath;

    @BeforeEach
    void setUp() throws IOException {
        this.keyPath = "speech-key.json";
        this.gateway = new MessageTranslateGoogleCloud(keyPath);
        this.presenter = new MessageTranslatePresenter();
        this.interactor = new MessageTranslateInteractor(gateway, presenter);
    }

    @Test
    void messageTranslateEnglishToFrench(){
        //Testing translating from English to another Latin alphabet language

        MessageTranslateData data = new MessageTranslateData(
                "Hello",
                "fr",
                "en-US"
        );
        MessageTranslateResponse actualResponse = interactor.translate(data);
        assertEquals("Bonjour", actualResponse.getResult());
    }

    @Test
    void messageTranslateEnglishToSpanish(){

        //Translating from a Latin language to English
        MessageTranslateData data = new MessageTranslateData(
                "Hello",
                "es",
                "en-US"
        );
        MessageTranslateResponse actualResponse = interactor.translate(data);
        assertEquals("Hola", actualResponse.getResult());
    }

    @Test
    void messageTranslateSpanishToFrench(){

        //Translating from 2 Latin Languages
        MessageTranslateData data = new MessageTranslateData(
                "Buenos dias",
                "fr",
                "es"
        );
        MessageTranslateResponse actualResponse = interactor.translate(data);
        assertEquals("Bonjour", actualResponse.getResult());
    }

    @Test
    void messageTranslateEnglishToChinese(){

        //Java seems to have some trouble with non latin characters
        //Represent using unicode
        MessageTranslateData data = new MessageTranslateData(
                "Hello",
                "zh",
                "en-US"
        );
        MessageTranslateResponse actualResponse = interactor.translate(data);
        assertEquals("\u4f60\u597d", actualResponse.getResult());
    }
}
