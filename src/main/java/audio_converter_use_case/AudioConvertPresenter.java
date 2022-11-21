package audio_converter_use_case;

public class AudioConvertPresenter implements AudioConvertOutputBoundary {

    @Override
    public AudioConvertResponse prepareSuccessView(AudioConvertResponse response) {
        return response;
    }

    @Override
    public AudioConvertResponse prepareFailView(String e) {
        throw new AudioConvertFailed(e);
    }


}
