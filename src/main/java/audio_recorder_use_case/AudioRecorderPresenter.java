package audio_recorder_use_case;

public class AudioRecorderPresenter implements AudioRecorderOutputBoundary{
    /**
     * Prepares the scenario in which converting the audio was successful
     * @param response
     *      contains a filePath, language, as well as the converted resulting string
     */
    @Override
    public AudioRecorderResponse prepareSuccessView(AudioRecorderResponse response) {
        return response;
    }
    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    @Override
    public AudioRecorderResponse prepareFailView(String e) {
        throw new AudioRecorderFailed(e);
    }
}
