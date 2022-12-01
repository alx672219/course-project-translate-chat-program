package audio_recorder_use_case;

public class AudioRecorderFailed extends RuntimeException{
    /**
     * @param message
     *      Error message
     */

    public AudioRecorderFailed(String message) {super(message);}
}
