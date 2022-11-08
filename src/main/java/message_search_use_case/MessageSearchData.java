package message_search_use_case;

public class MessageSearchData {
    private final String text;

    /**
     * Constructor for MessageSearchData.
     * @param text the text to be searched
     */
    public MessageSearchData(String text) {
        this.text = text;
    }

    /**
     * Getter method for text.
     * @return text attribute for this MessageSearchData object.
     */
    public String getText() {
        return text;
    }
}
