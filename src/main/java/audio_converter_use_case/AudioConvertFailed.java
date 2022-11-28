package audio_converter_use_case;

public class AudioConvertFailed extends RuntimeException{
    /**
     * @param message
     *      Error message
     */
    public AudioConvertFailed(String message) {super(message);}
}
