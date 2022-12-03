package message_search_use_case;

import shared.Response;

import java.util.List;
import java.util.Map;

public class MessageSearchResponse extends Response {
    private final String text;
    private final List<Map<String, String>> messages;

    /**
     * Constructor for MessageSearchResponse.
     * @param text text that was searched
     * @param success whether message search was successful
     * @param e exception that was thrown if success is false, null otherwise
     */
    public MessageSearchResponse(String text, List<Map<String, String>> messages, boolean success, Exception e) {
        this.text = text;
        this.messages = messages;
        this.success = success;
        this.e = e;
    }

    /**
     * Getter method for text.
     * @return the text attribute of this MessageSearchResponse object\
     */
    public String getText() {
        return this.text;
    }

    /**
     * Getter method for e.
     * @return the e (exception) attribute for this MessageSearchResponse object
     */
    public Exception getException() {
        return super.e;
    }

    /**
     * Getter method for messages.
     * @return the messages attribute of this MessageSearchResponse object\
     */
    public List<Map<String, String>> getMessages() {
        return messages;
    }
}
