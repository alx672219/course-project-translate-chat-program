package message_search_use_case;

public class MessageSearchInteractor implements MessageSearchInputBoundary {

    final MessageSearchGateway gateway;
    final MessageSearchOutputBoundary presenter;

    /**
     * Constructor for MessageSearchInteractor.
     * @param gateway database to access messages
     * @param presenter presenter to let UI know what it should do
     */
    public MessageSearchInteractor(MessageSearchGateway gateway, MessageSearchOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     * Search for messages that match data and return a MessageSearchResponse object.
     * @param data data to match messages with
     * @return MessageSearchResponse object indicating what to show the user
     */
    @Override
    public MessageSearchResponse search(MessageSearchData data) {
        //TODO: Implement method (perform checks, etc.)
        return null;
    }
}
