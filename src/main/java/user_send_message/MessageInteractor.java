package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;
import services.DBService;

import java.text.ParseException;
import java.time.LocalDate;
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
        DBService dbService = new DBService();
        Chat currChat = dbService.getChatDetails(chatID);

        User sender = dbService.getUserDetails(senderID);
        User receiver = dbService.getUserDetails(receiverID);

        MessageFactory messageFactory = new MessageFactory();
        List<Integer> messageIDs = null;

        try {
            messageIDs = dbService.getAllMessageIDs();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        int nextMessageID = Collections.max(messageIDs) + 1;

        Message messsageToSend = messageFactory.createMessage(chatID, nextMessageID, message, sender, receiver, timestamp);
        // Gateway
        SendMessageGateway sendMessageGateway = new SendMessageGateway();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
    }

}
