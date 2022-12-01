package gateways;

import audio_recorder_use_case.AudioRecorderGateway;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioRecorder implements AudioRecorderGateway {
    static final long MAX_RECORD_TIME = 15; //15 second recording because google charges per 15 seconds
    boolean recording;
    File wavFile = new File("src/main/Others/RecordedAudio.wav"); //location
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE; //file type, .wav
    TargetDataLine line;

    public AudioRecorder(){this.recording = false;}
    private void start() {
        try {
            this.recording = true;
            AudioFormat format = getDefaultAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();
            AudioInputStream ais = new AudioInputStream(line);

            // start recording
            AudioSystem.write(ais, fileType, wavFile);


        } catch (LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private void finish() {
        this.recording = false;
        line.stop();
        line.close();
    }

    public AudioFormat getDefaultAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
    }

    @Override
    public boolean isRecording() {
        return recording;
    }

    public void record() {
        if(recording){finish();}
        else {
            //Makes a new thread so we can record at the same time the program runs
            Thread stopper = new Thread(() -> {
                try {
                    for (int i = 1; i <= MAX_RECORD_TIME-1; i++) {
                        if (!recording) {
                            break;
                        }
                        Thread.sleep(1000);//The thread sleeps for as long as we record, this determines how long our recording is
                        if (i == MAX_RECORD_TIME-1) {
                            finish();
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
            stopper.start();
            // start recording
            start();
        }

    }
}
