package audio_recorder_use_case;

import shared.Response;

public class AudioRecorderResponse extends Response {
    /**
     * Response class containing the current state of the recorder.
     * This is true if the application is currently recording audio, and false
     * if it is not currently recording audio.
     */
    private boolean record;
    public AudioRecorderResponse(boolean record, boolean success, Exception e) {
        this.record = record;
        this.success = success;
        this.e = e;
    }

    public boolean isRecord() {
        return record;
    }

    @Override
    public Exception getException() {
        return super.e;
    }
}
