package audio_recorder_use_case;

import audio_converter_use_case.AudioConvertResponse;

public interface AudioRecorderOutputBoundary {

    AudioRecorderResponse prepareSuccessView(AudioRecorderResponse response);
    AudioRecorderResponse prepareFailView(String error);
}
