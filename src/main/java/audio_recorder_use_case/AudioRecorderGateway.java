package audio_recorder_use_case;

import atranslate_use_case.MessageTranslateData;

import java.io.IOException;

public interface AudioRecorderGateway {
    boolean isRecording();
    void record();

}
