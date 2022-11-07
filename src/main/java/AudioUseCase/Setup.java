package AudioUseCase;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.speech.v1.*;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.protobuf.ByteString;


import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Setup {

    public static void main(String[] args) throws Exception{
        //SpeechClient speech = SpeechClient.create(); //creates client

        SpeechSettings settings =
                SpeechSettings.newBuilder()
                        .setCredentialsProvider(FixedCredentialsProvider.create(ServiceAccountCredentials.fromStream(new FileInputStream("src/main/Others/Speech_key.json"))))
                        .build();
        SpeechClient speech = SpeechClient.create(settings);

        String fileName = "src/main/Others/RecordAudio2.wav"; //file for audio
        System.out.println(1);
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        ByteString audioBytes = ByteString.copyFrom(data); //reads in the audio


        RecognitionConfig config =
                RecognitionConfig.newBuilder()
                        .setEncoding(AudioEncoding.LINEAR16)
                        .setSampleRateHertz(16000)
                        .setAudioChannelCount(2)
                        .setLanguageCode("en-US")
                        .build();
        RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();//builds request


        RecognizeResponse response = speech.recognize(config, audio);
        List<SpeechRecognitionResult> results = response.getResultsList();//speech recognition

        for (SpeechRecognitionResult result : results) {
            List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
            for (SpeechRecognitionAlternative alternative : alternatives) {
                System.out.printf("Transcription: %s%n", alternative.getTranscript());
            }
        }
        speech.close();//results

    }
}
