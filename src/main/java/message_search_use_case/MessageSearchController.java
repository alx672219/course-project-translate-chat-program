package message_search_use_case;

public class MessageSearchController {
    final MessageSearchInputBoundary messageSearchInput;

    public MessageSearchController(MessageSearchInputBoundary messageSearchInput) {
        this.messageSearchInput = messageSearchInput;
    }

    MessageSearchResponse search(MessageSearchData data) {
        return this.messageSearchInput.search(data);
    }
}
