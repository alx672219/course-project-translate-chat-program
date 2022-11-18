package audio_converter_use_case;

import java.io.IOException;

public class AudioConvertInteractor implements AudioConvertInputBoundary {
final AudioConvertGateway gateway;
final AudioConvertPresenter presenter;

public AudioConvertInteractor(AudioConvertGateway gateway, AudioConvertPresenter presenter){
this.gateway = gateway;
this.presenter = presenter;
}

    @Override
    public AudioConvertResponse convert(AudioConvertData data) throws IOException {

    //Do failure cases

        String result = gateway.convert(data);
        AudioConvertResponse response = new AudioConvertResponse(data.getFilePath(), data.getLanguageCode(), result,
                true, null);
        return presenter.prepareSuccessView(response);
    }
}
