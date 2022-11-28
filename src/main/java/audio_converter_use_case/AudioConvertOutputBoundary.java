package audio_converter_use_case;

public interface AudioConvertOutputBoundary {
    /**
     * Prepares the scenario in which converting the audio was successful
     * @param response
     *      contains a filePath, language, as well as the converted resulting string
     */
    AudioConvertResponse prepareSuccessView(AudioConvertResponse response);

    /**
     * Prepares in the scenario of a failure
     * @param error
     *      The error message
     */
    AudioConvertResponse prepareFailView(String error);
}
