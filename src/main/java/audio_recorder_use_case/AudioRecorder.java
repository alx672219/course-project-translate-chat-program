package audio_recorder_use_case;
import javax.sound.sampled.*;
import java.io.*;

public class AudioRecorder {
    static final long RECORD_TIME = 15000; //15 second recording because google charges per 15 seconds
    File wavFile = new File("src/main/Others/RecordAudio2.wav"); //location
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE; //file type, .wav
    TargetDataLine line;

    AudioFormatFactory audioFormatFactory;
    public AudioRecorder(){
        AudioFormatFactory audioFormatFactory = new AudioFormatFactory();
    }

    void start() {
        try {
            AudioFormat format = audioFormatFactory.getAudioFormat();
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
        line.stop();
        line.close();
    }


    public static void main(String[] args) {
        final AudioRecorder recorder = new AudioRecorder();

        //Makes a new thread so we can record at the same time the program runs
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);//The thread sleeps for as long as we record, this determines how long our recording is
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });

        stopper.start();

        // start recording
        recorder.start();
    }



}
