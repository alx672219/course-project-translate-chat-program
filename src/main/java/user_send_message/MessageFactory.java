package user_send_message;

import entities.Message;
import entities.TextMessage;
import entities.User;

import java.util.Date;

public class MessageFactory implements MessageInputBoundary {
    public TextMessage createMessage(int id, String messsage, User receiver, User recipient, Date timestamp) {
        return new TextMessage(id, messsage, receiver, recipient, timestamp);
    }
}
