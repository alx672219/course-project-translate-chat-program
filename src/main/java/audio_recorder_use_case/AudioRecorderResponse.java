package audio_recorder_use_case;

import shared.Response;

public class AudioRecorderResponse extends Response {
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
