package audio_converter_use_case;


import java.io.IOException;

public interface AudioConvertGateway {
    /**
     * @param filePath String, the audio file being converted
     * @param languageCode, the language of the audio file
     * @return a string of text from the audio file
     */

    String convert(AudioConvertData audioConvertData) throws IOException;


}
