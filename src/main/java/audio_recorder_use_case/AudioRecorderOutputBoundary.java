package audio_recorder_use_case;

public interface AudioRecorderOutputBoundary {
    /**
     * Prepares the scenario in which recording audio is successful
     * @param response
     *      contains the whether or not the recorder is recording or not
     */
    AudioRecorderResponse prepareSuccessView(AudioRecorderResponse response);
    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    AudioRecorderResponse prepareFailView(String error);
}
