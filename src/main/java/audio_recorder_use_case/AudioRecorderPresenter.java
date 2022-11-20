package audio_recorder_use_case;

import atranslate_use_case.MessageTranslateFailed;
import atranslate_use_case.MessageTranslateResponse;

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
