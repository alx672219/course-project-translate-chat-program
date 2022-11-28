package audio_recorder_use_case;

import audio_converter_use_case.AudioConvertData;
import audio_converter_use_case.AudioConvertGateway;
import audio_converter_use_case.AudioConvertOutputBoundary;
import audio_converter_use_case.AudioConvertPresenter;

import java.io.IOException;
//#TODO
public class AudioRecorderInteractor implements AudioRecorderInputBoundary {
    final AudioRecorderGateway gateway;
    final AudioRecorderOutputBoundary presenter;

    public AudioRecorderInteractor(AudioRecorderGateway gateway, AudioRecorderOutputBoundary presenter){
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public AudioRecorderResponse record() {
        gateway.record();
        return new AudioRecorderResponse(gateway.isRecording(), true, null);
    }
}
