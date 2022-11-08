package message_search_use_case;

public class MessageSearchFailed extends RuntimeException {
    public MessageSearchFailed(String error) {
        super(error);
    }
}
