package gateways;

import audio_converter_use_case.AudioConvertData;
import audio_converter_use_case.AudioConvertGateway;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AudioConvertGoogleCloud implements AudioConvertGateway {
    private final SpeechClient speech;

    public AudioConvertGoogleCloud(String keyPath) throws IOException {
        //Path containing the json file with the API key
        this.speech = createSpeechClient(keyPath);
    }



    @Override
    public String convert(AudioConvertData audioConvertData) throws IOException {
        String FilePath = audioConvertData.getFilePath();
        String LanguageCode = audioConvertData.getLanguageCode();

        StringBuilder translatedText = new StringBuilder();
        ByteString audioBytes = createAudioBytes(FilePath);
        RecognitionConfig config = createRecognitionConfig(16000, 2, LanguageCode);
        RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

        RecognizeResponse response = speech.recognize(config, audio);
        List<SpeechRecognitionResult> results = response.getResultsList();

        for (SpeechRecognitionResult result : results) {
            List<SpeechRecognitionAlternative> alternatives = result.getAlternativesList();
            for (SpeechRecognitionAlternative alternative : alternatives) {
                translatedText.append(alternative.getTranscript());
            }
        }
        return translatedText.toString();
    }

    public ByteString createAudioBytes(String File) throws IOException {
        Path path = Paths.get(File);
        byte[] data = Files.readAllBytes(path);

        return ByteString.copyFrom(data);
    }
    public RecognitionConfig createRecognitionConfig(int sampleRateHertz, int audioChannelCount, String LanguageCode){
        return RecognitionConfig.newBuilder()
                .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                .setSampleRateHertz(sampleRateHertz)
                .setAudioChannelCount(audioChannelCount)
                .setLanguageCode(LanguageCode)
                .build();
    }
    public SpeechClient createSpeechClient(String keyPath) throws IOException {
        SpeechSettings settings =
                SpeechSettings.newBuilder()
                        .setCredentialsProvider(FixedCredentialsProvider
                                .create(ServiceAccountCredentials
                                        .fromStream(new FileInputStream(keyPath))))
                        .build();
        return SpeechClient.create(settings);
    }
}
