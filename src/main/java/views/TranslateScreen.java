package views;

import translate_use_case.MessageTranslateData;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TranslateScreen extends JFrame {

    JTextArea translatedText;
    MessageTranslateController MTC;

    public TranslateScreen(MessageTranslateData data, MessageTranslateController MTC) throws IOException {
        this.MTC = MTC;
        this.setSize(600,200);
        this.setLocation(
                (int)MouseInfo.getPointerInfo().getLocation().getX() + 10,
                (int)MouseInfo.getPointerInfo().getLocation().getY());
        translatedText = new JTextArea(MTC.translate(data).getResult());
        translatedText.setLineWrap(true);
        translatedText.setEditable(false);
        this.add(translatedText);
        this.setVisible(true);


    }


}
