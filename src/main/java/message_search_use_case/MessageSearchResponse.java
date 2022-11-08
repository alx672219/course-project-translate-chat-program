package message_search_use_case;

import shared.Response;

public class MessageSearchResponse extends Response {
    private String text;

    /**
     * Constructor for MessageSearchResponse.
     * @param text text that was searched
     * @param success whether message search was successful
     * @param e exception that was thrown if success is false, null otherwise
     */
    public MessageSearchResponse(String text, boolean success, Exception e) {
        this.text = text;
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
}
