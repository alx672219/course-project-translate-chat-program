package audio_recorder_use_case;

public class AudioRecorderPresenter implements AudioRecorderOutputBoundary{

    @Override
    public AudioRecorderResponse prepareSuccessView(AudioRecorderResponse response) {
        return response;
    }

    @Override
    public AudioRecorderResponse prepareFailView(String e) {
        throw new AudioRecorderFailed(e);
    }
}
