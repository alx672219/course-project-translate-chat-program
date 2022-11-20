package audio_recorder_use_case;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioRecorder {
    static final long MAX_RECORD_TIME = 15; //15 second recording because google charges per 15 seconds

    boolean recording;
    File wavFile = new File("src/main/Others/RecordAudio2.wav"); //location
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE; //file type, .wav
    TargetDataLine line;

    public AudioRecorder(){this.recording = false;}
    void start() {
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

    void finish() {
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
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }
    public static void main(String[] args) {
        final AudioRecorder recorder = new AudioRecorder();

        //Makes a new thread so we can record at the same time the program runs
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i = 0; i < MAX_RECORD_TIME; i++){
                        Thread.sleep(1000);//The thread sleeps for as long as we record, this determines how long our recording is
                        System.out.println(i);
                        if (!recorder.recording){
                            break;
                        }

                        if (i == MAX_RECORD_TIME - 1){
                            recorder.finish();
                        }
                    }

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        System.out.println("STARTING");
        stopper.start();
        // start recording
        recorder.start();

    }



}
