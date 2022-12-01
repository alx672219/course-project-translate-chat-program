package translate_use_case;

public class MessageTranslateFailed extends RuntimeException{
    /**
     * @param message
     *      Error message
     */
    public MessageTranslateFailed(String message) {super(message);}
}
