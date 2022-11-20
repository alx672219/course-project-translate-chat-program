package views.TempSamStuff;

import audio_converter_use_case.*;
import audio_recorder_use_case.*;
import gateways.AudioConvertGoogleCloud;
import gateways.AudioRecorder;

import javax.swing.*;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        AudioConvertPresenter ACP = new AudioConvertPresenter();
        AudioConvertGoogleCloud ACGC = new AudioConvertGoogleCloud("speech-key.json");
        AudioConvertInteractor ACI = new AudioConvertInteractor(ACGC, ACP);


        AudioRecorderPresenter ARP = new AudioRecorderPresenter();
        AudioRecorder AR = new AudioRecorder();
        AudioRecorderInteractor ARI = new AudioRecorderInteractor(AR, ARP);

        AudioConvertController ACC = new AudioConvertController(ACI);
        AudioRecorderController ARC = new AudioRecorderController(ARI);

        RecordButton rc = new RecordButton(ARC, ACC);

        JFrame frame = new JFrame();
        frame.add(rc);
        frame.setVisible(true);
    }
}
