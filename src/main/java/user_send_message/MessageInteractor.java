package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;

import java.time.LocalDate;
import java.util.Date;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    @Override
    public void sendMessage(int chatID, int id, String message, User receiver, User recipient, LocalDate timestamp) {
        MessageFactory messageFactory = new MessageFactory();
        Message messsageToSend = messageFactory.createMessage(chatID, id, message, receiver, recipient, timestamp);
        // Gateway

    }

}
