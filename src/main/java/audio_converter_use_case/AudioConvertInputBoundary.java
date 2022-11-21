package audio_converter_use_case;

import java.io.IOException;

public interface AudioConvertInputBoundary {
    /** Outgoing data to convert audio files into text
    * @param data AudioConvertData contains a filepath and a language code
    * @return AudioConvertResponse contains response data as well as the converted text
    */

    AudioConvertResponse convert(AudioConvertData data) throws IOException;
}
