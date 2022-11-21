package views;

import audio_converter_use_case.AudioConvertData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;



public class RecordButton extends JPanel implements ActionListener {
    JButton recordButton;
    JPanel panel;
    JTextField textBox;
    JLabel timeLabel;
    AudioRecorderController audioRecorderController;
    AudioConvertController audioConvertController;
    boolean recording;



    ImageIcon micImage;

    public RecordButton(AudioRecorderController ARC, AudioConvertController ACC){
        this.recording = false;
        this.audioRecorderController = ARC;
        this.audioConvertController =  ACC;
        this.panel = new JPanel();
        this.textBox = new JTextField();
        this.recordButton = new JButton();
        this.timeLabel = new JLabel();

        recordButton.addActionListener(this);

        this.add(textBox);
        this.add(recordButton);
        this.add(timeLabel);


    }
public void display() throws IOException {
    String translation = audioConvertController
            .convert(new AudioConvertData("src/main/Others/RecordedAudio.wav", "en"))
            //#TODO this data should be gathered from the chat screen, once everything is put together
            .getResult();
    textBox.setText(translation);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        this.recording = this.audioRecorderController.record().isRecord();
        if (recording) {
            Thread counter = new Thread(new Runnable() {
                public void run() {
                    try {
                        for (int i = 1; i <= 15-1; i++) {
                            if (!recording) {
                                timeLabel.setText(""+i);
                                break;
                            }
                            Thread.sleep(1000);//The thread sleeps for as long as we record, this determines how long our recording is
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    timeLabel.setText("");
                    try {
                        display();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            });
            counter.start();
        } else {
            try {
                display();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
