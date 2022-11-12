package user_send_message;

import entities.TextMessage;
import entities.User;

import java.util.Date;

public class SendMessageController {
    private final MessageInputBoundary messageInputBoundary;
    private final MessageOutputBoundary messageOutputBoundary;

    public SendMessageController(MessageInputBoundary messageInputBoundary, MessageOutputBoundary messageOutputBoundary) {
        this.messageInputBoundary = messageInputBoundary;
        this.messageOutputBoundary = messageOutputBoundary;
    }

    /** Creates the message to be sent
     *
     * @param id
     * @param message
     * @param receiver
     * @param recipient
     * @param timestamp
     * @return Returns the created message
     */
    private TextMessage createMessage(int id, String message, User receiver, User recipient, Date timestamp) {
        return messageInputBoundary.createMessage(id, message, receiver, recipient, timestamp);
    }

    /** Sends the created message
     *
     * @param id
     * @param message
     * @param receiver
     * @param recipient
     * @param timestamp
     */
    public void sendMessage(int id, String message, User receiver, User recipient, Date timestamp) {
        TextMessage messageToSend = createMessage(id, message, receiver, recipient, timestamp);
        this.messageOutputBoundary.sendMessage(messageToSend);
    }

}
