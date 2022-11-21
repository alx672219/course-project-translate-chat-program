package audio_converter_use_case;

public interface AudioConvertOutputBoundary {

    AudioConvertResponse prepareSuccessView(AudioConvertResponse response);
    AudioConvertResponse prepareFailView(String error);
}
