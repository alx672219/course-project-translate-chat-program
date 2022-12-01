package user_send_message;

import entities.Message;
import entities.User;

import java.util.Date;

public class MessageFactory  {
    public Message createMessage(int id, String message, User receiver, User recipient, Date timestamp) {
        return new Message(id, message, receiver, recipient, timestamp);
    }
}
