package user_send_message;

import entities.Message;
import entities.TextMessage;
import entities.User;

import java.util.Date;

public interface MessageInputBoundary {
    /**
     * Creates a message
     *
     * @param data needed to create message instance
     * @return the message created
     */

    TextMessage createMessage(int id, String message, User receiver, User recipient, Date timestamp);
}
