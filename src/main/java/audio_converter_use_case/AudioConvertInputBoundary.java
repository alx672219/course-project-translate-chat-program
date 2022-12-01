package audio_converter_use_case;

import java.io.IOException;

public interface AudioConvertInputBoundary {
    /**
    * @param data
     *      data contains a filepath, and the language of the audio file
    * @return
     *      AudioConvertResponse contains the filepath, language, and the resulting string
    */

    AudioConvertResponse convert(AudioConvertData data) throws IOException;
}
