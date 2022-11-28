package audio_recorder_use_case;

public interface AudioRecorderGateway {
    /**
     * @return
     *      Returns true or false, depending on if the gateway is currently recording
     */
    boolean isRecording();

    /**
     * Begins or stops the recording
     */

    void record();

}
