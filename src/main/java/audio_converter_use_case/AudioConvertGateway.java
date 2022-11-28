package audio_converter_use_case;


import java.io.IOException;

public interface AudioConvertGateway {
    /**
     * @param audioConvertData
     *      A bundle containing the path and details of an audio file
     * @return A string of text extracted from the audio convert data
     */

    String convert(AudioConvertData audioConvertData) throws IOException;


}
