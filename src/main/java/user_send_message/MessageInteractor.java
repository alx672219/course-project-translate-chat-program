package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGatewayImplementation;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    SendMessageGateway sendMessageGateway;

    public MessageInteractor(SendMessageGateway sendMessageGateway) {
        this.sendMessageGateway = sendMessageGateway;
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
        SendMessageGatewayImplementation sendMessageGateway = new SendMessageGatewayImplementation();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
    }

}
