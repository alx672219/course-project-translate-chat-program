package user_send_message;

import entities.Message;
import entities.User;
import gateways.SendMessageGatewayImplementation;

import java.text.ParseException;
import java.util.*;
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
     * @param chatID ID of the chat
     * @param message Text of the message
     * @param senderID needed to create message instance
     * @param receiverID ID of the receiver
     * @param timestamp Timestamp of the message
     * @return The response indicating whether a message was sent successfully
     * @throws ExecutionException if data cannot be retrieved from database
     * @throws InterruptedException if the process of getting data is interrupted
     * @throws ParseException if timestamp cannot be parsed
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
        return new SendMessageResponse(messsageToSend.getId(), true, null);
    }

    /**
     * Retrieves all the messages in a chat
     * @param chatID ID of the chat
     * @return List of all messages in a chat
     */
    @Override
    public ArrayList<Map<String, Object>> getAllMessages(int chatID) {
        ArrayList<Message> messages = sendMessageGateway.getMessagesByChat(chatID);
        ArrayList<Map<String, Object>> messageMaps = new ArrayList<>();
        for (Message message : messages) {
            Map<String, Object> messageMap = new HashMap<>();
            messageMap.put("sender_name", message.getReceiver().getName());
            messageMap.put("sender_id", message.getReceiver().getUser_id());
            messageMap.put("message", message.getMessage());
            messageMap.put("id", message.getId());
            messageMaps.add(messageMap);
        }
        return messageMaps;
    }

    /**
     * Retrieves the chatID used by the given two users
     * @param userID ID of the main user
     * @param contactID ID of the other user
     * @return ChatID corresponding to two users
     */
    @Override
    public int getChatIDByUsers(int userID, int contactID) {
        return sendMessageGateway.getChatIDByUsers(userID, contactID);
    }
}
