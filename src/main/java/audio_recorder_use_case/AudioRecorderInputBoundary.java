package audio_recorder_use_case;

import audio_converter_use_case.AudioConvertData;
import audio_converter_use_case.AudioConvertResponse;

import java.io.IOException;

public interface AudioRecorderInputBoundary {
    AudioRecorderResponse record();
}
