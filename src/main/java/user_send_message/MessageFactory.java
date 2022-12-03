package user_send_message;

import entities.Message;
import entities.User;

import java.util.Date;

/**
 * Message Factory class used to create messages
 */
public class MessageFactory  {
    /**
     * Creates a message instance using the given data
     * @param id
     * @param message
     * @param receiver
     * @param recipient
     * @param timestamp
     * @return The message created using the given data
     */
    public Message createMessage(int id, String message, User receiver, User recipient, Date timestamp) {
        return new Message(id, message, receiver, recipient, timestamp);
    }
}
