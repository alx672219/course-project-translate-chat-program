package audio_recorder_use_case;

public class AudioRecorderInteractor implements AudioRecorderInputBoundary {
    final AudioRecorderGateway gateway;
    final AudioRecorderOutputBoundary presenter;

    public AudioRecorderInteractor(AudioRecorderGateway gateway, AudioRecorderOutputBoundary presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     * Begins or stops the recording process
     * @return
     *      Returns an AudioRecorderResponse containing the current state of whether or not
     *      the gateway is recording.
     */
    @Override
    public AudioRecorderResponse record() {
        gateway.record();
        return new AudioRecorderResponse(gateway.isRecording(), true, null);
    }
}
