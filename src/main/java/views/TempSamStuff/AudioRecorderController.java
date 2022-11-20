package views.TempSamStuff;

import audio_recorder_use_case.AudioRecorderInputBoundary;
import audio_recorder_use_case.AudioRecorderResponse;


public class AudioRecorderController {
    final AudioRecorderInputBoundary audioRecorderInputBoundary;

    public AudioRecorderController(AudioRecorderInputBoundary audioRecorderInputBoundary) {
        this.audioRecorderInputBoundary = audioRecorderInputBoundary;
    }

    AudioRecorderResponse record() {
        return this.audioRecorderInputBoundary.record();
    }
}
