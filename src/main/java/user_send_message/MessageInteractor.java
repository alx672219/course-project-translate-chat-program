package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ExecutionException;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    @Override
    public void sendMessage(int chatID, int id, String message, User receiver, User recipient, Date timestamp) throws ExecutionException, InterruptedException {
        MessageFactory messageFactory = new MessageFactory();
        Message messsageToSend = messageFactory.createMessage(chatID, id, message, receiver, recipient, timestamp);
        // Gateway
        SendMessageGateway sendMessageGateway = new SendMessageGateway();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
    }

}
