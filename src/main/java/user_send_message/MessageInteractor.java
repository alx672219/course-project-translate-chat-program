package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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
    public void sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
//        Chat currChat = dbService.getChatDetails(chatID);

        User sender = sendMessageGateway.getUserDetails(senderID);
        User receiver = sendMessageGateway.getUserDetails(receiverID);

        MessageFactory messageFactory = new MessageFactory();


        List<Integer> messageIDs = sendMessageGateway.getAllMessages();

        int nextMessageID = Collections.max(messageIDs) + 1;

        Message messsageToSend = messageFactory.createMessage(chatID, nextMessageID, message, sender, receiver, timestamp);
        // Gateway
        sendMessageGateway.sendMessage(chatID, messsageToSend);
    }

}