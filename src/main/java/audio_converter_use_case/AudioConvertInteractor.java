package audio_converter_use_case;

import java.io.IOException;

public class AudioConvertInteractor implements AudioConvertInputBoundary {
final AudioConvertGateway gateway;
final AudioConvertOutputBoundary presenter;

public AudioConvertInteractor(AudioConvertGateway gateway, AudioConvertPresenter presenter){
this.gateway = gateway;
this.presenter = presenter;
}

    /**
     * The method convert calls the gateway, which takes in audio data, and outputs
     * a string containing the spoken audio.
     *
     * In the case of an exception, such as an IOException, it will fail instead.
     * @param data
     *      data contains a filepath, and the language of the audio file
     * @return
     * AudioConvertResponse, contains the filePath, language, as well as the resulting string
     */
    @Override
    public AudioConvertResponse convert(AudioConvertData data) {
        try {
            String result = gateway.convert(data);
            AudioConvertResponse response = new AudioConvertResponse(data.getFilePath(), data.getLanguageCode(), result,
                    true, null);
            return presenter.prepareSuccessView(response);
        } catch (IOException e) {
            return presenter.prepareFailView(e.getMessage());
        }
    }
}
