package user_send_message;

import entities.Message;
import entities.User;
import gateways.SendMessageGatewayImplementation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Message interactor for sending a message
 */
public class MessageInteractor implements MessageInputBoundary {
    /**
     * The gateway where messages will be persisted to the database
     */
    SendMessageGateway sendMessageGateway;

    public MessageInteractor(SendMessageGateway sendMessageGateway) {
        this.sendMessageGateway = sendMessageGateway;
    }

    /**
     * Attempts to send a message with the given today
     * @param chatID
     * @param message
     * @param senderID needed to create message instance
     * @param receiverID
     * @param timestamp
     * @return The response indicating whether a message was sent successfully
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws ParseException
     */
    @Override
    public SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
        User sender = sendMessageGateway.getUserDetails(senderID);
        User receiver = sendMessageGateway.getUserDetails(receiverID);

        // Factory that will create the message to be sent
        MessageFactory messageFactory = new MessageFactory();

        List<Integer> messageIDs = sendMessageGateway.getAllMessages();
        // Calculates next message ID to be the max of all message IDs + 1
        int nextMessageID = Collections.max(messageIDs) + 1;

        // Message constructed to be sent to database
        Message messsageToSend = messageFactory.createMessage(nextMessageID, message, sender, receiver, timestamp);

        // Gateway
        sendMessageGateway = new SendMessageGatewayImplementation();
        sendMessageGateway.sendMessage(chatID, messsageToSend);
        return new SendMessageResponse(messsageToSend, true, null);
    }

    /**
     * Retrieves all the messages in a chat
     * @param chatID
     * @return List of all messages in a chat
     */
    @Override
    public ArrayList<Message> getAllMessages(int chatID) {
        return sendMessageGateway.getMessagesByChat(chatID);
    }

    /**
     * Retrieves the chatID used by the given two users
     * @param userID
     * @param contactID
     * @return ChatID corresponding to two users
     */
    @Override
    public int getChatIDByUsers(int userID, int contactID) {
        return sendMessageGateway.getChatIDByUsers(userID, contactID);
    }
}
