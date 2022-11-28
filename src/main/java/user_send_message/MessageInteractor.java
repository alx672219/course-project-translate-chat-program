package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGatewayImplementation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
//import entities.TextMessage;

public class MessageInteractor implements MessageInputBoundary {
    SendMessageGateway sendMessageGateway;

    public MessageInteractor(SendMessageGateway sendMessageGateway) {
        this.sendMessageGateway = sendMessageGateway;
    }

    @Override
    public SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
//        Chat currChat = dbService.getChatDetails(chatID);

        User sender = sendMessageGateway.getUserDetails(senderID);
        User receiver = sendMessageGateway.getUserDetails(receiverID);

        MessageFactory messageFactory = new MessageFactory();


        List<Integer> messageIDs = sendMessageGateway.getAllMessages();

        int nextMessageID = Collections.max(messageIDs) + 1;

        Message messsageToSend = messageFactory.createMessage(chatID, nextMessageID, message, sender, receiver, timestamp);
        // Gateway
        sendMessageGateway = new SendMessageGatewayImplementation();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
        SendMessageResponse response = new SendMessageResponse(messsageToSend, true, null);
        return response;
    }

    @Override
    public ArrayList<Message> getAllMessages(int chatID) {
        return sendMessageGateway.getMessagesByChat(chatID);
    }

    @Override
    public int getChatIDByUsers(int userID, int contactID) {
        return sendMessageGateway.getChatIDByUsers(userID, contactID);
    }

}
