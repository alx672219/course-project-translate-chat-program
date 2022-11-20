package user_send_message;

import entities.Chat;
import entities.Message;
//import entities.TextMessage;
import entities.User;

import java.time.LocalDate;
import java.util.Date;

public class MessageFactory  {
    public Message createMessage(int chatID, int id, String message, User receiver, User recipient, Date timestamp) {
        Message newMessage = new Message(id, message, receiver, recipient, timestamp);
        return newMessage;
    }
}
