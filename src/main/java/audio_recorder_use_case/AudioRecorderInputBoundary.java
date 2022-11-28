package audio_recorder_use_case;

public interface AudioRecorderInputBoundary {
    /**
     * Begins or stops the recording
     */
    AudioRecorderResponse record();
}
