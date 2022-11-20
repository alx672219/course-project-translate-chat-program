package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ExecutionException;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    SendMessageGateway sendMessageGateway;

    public MessageInteractor() {
        sendMessageGateway = new SendMessageGateway();
    }

    @Override
    public void createChat(int chatID) throws ExecutionException, InterruptedException {
        Chat chat = new Chat(chatID);
        sendMessageGateway.addChat(chat);
    }

    @Override
    public void sendMessage(int chatID, int id, String message, User receiver, User recipient, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
        MessageFactory messageFactory = new MessageFactory();
        Message messsageToSend = messageFactory.createMessage(chatID, id, message, receiver, recipient, timestamp);
        // Gateway
        SendMessageGateway sendMessageGateway = new SendMessageGateway();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
    }

}
