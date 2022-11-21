package views.TempSamStuff;

import atranslate_use_case.MessageTranslateData;

import javax.swing.*;
import java.io.IOException;

public class TranslateScreen extends JFrame {

    JLabel translatedText;
    MessageTranslateController MTC;

    public TranslateScreen(MessageTranslateData data, int x, int y, MessageTranslateController MTC) throws IOException {
        this.MTC = MTC;
        this.setSize(200,100);
        this.setLocation(x + 5, y + 5);
        translatedText = new JLabel(MTC.translate(data).getResult());
        this.add(translatedText);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);


    }


}
