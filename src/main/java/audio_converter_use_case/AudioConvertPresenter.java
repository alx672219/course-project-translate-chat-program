package audio_converter_use_case;

public class AudioConvertPresenter implements AudioConvertOutputBoundary {
    /**
     * Prepares the scenario in which converting the audio was successful
     * @param response
     *      contains a filePath, language, as well as the converted resulting string
     */
    @Override
    public AudioConvertResponse prepareSuccessView(AudioConvertResponse response) {
        return response;
    }
    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    @Override
    public AudioConvertResponse prepareFailView(String error) {
        throw new AudioConvertFailed(error);
    }


}
