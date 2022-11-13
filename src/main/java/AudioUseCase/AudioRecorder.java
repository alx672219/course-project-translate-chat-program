package AudioUseCase;
import javax.sound.sampled.*;
import java.io.*;

public class AudioRecorder {
    static final long RECORD_TIME = 15000; //15 second recording because google charges per 15 seconds
    File wavFile = new File("src/main/Others/RecordAudio2.wav"); //location

    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE; //file type, .wav
    TargetDataLine line;

    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    } //Audio format, i reference it again in the setup program for now

    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            } //This apparently checks a line, not too sure what it is but it is required to work


            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();   // start capturing

            System.out.println("Start capturing...");

            AudioInputStream ais = new AudioInputStream(line);

            System.out.println("Start recording...");

            // start recording
            AudioSystem.write(ais, fileType, wavFile);

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
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
