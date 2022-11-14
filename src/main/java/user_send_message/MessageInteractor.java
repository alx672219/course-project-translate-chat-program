package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;

import java.util.Date;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    @Override
    public void sendMessage(Chat chat, int id, String message, User receiver, User recipient, Date timestamp) {
        MessageFactory messageFactory = new MessageFactory();
        Message messsageToSend = messageFactory.createMessage(chat, id, message, receiver, recipient, timestamp);
        // Gateway

    }

}
