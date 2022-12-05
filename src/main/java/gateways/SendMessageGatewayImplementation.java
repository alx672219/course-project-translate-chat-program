package gateways;

import entities.Chat;
import entities.Message;
import entities.User;
import services.DBService;
import user_send_message.SendMessageGateway;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The gateway class for the send message use case
 */
public class SendMessageGatewayImplementation implements SendMessageGateway {
    // Instance of the DB service to use for send message use case
    DBService dbService;

    public SendMessageGatewayImplementation() {
        dbService = DBService.getInstance();
    }

    /**
     * Fetches the user instance corresponding to a user id from the database
     * @param userID ID of the user
     * @return the user instance corresponding to the given user id
     * @throws ExecutionException if data cannot be retrieved from database
     * @throws InterruptedException if the process of getting data is interrupted
     */
    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        return dbService.getUserDetails(userID);
    }

    /**
     * Fetches all the messages from the database
     * @return A list of all the messages in the database
     */
    public List<Integer> getAllMessages() {
        List<Integer> messageIDs;

        try {
            messageIDs = dbService.getAllIDs("messages");
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return messageIDs;
    }

    /**
     * Fetches all the messages in a chat from the database
     * @param chatID ID of the chat
     * @return A list of all the messages in the given chat
     */
    @Override
    public ArrayList<Message> getMessagesByChat(int chatID) {
        try {
            return dbService.getAllMessages(chatID);
        } catch (ExecutionException | InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getChatIDByUsers(int userID, int contactID) {
        return dbService.getChatIDByUsers(userID, contactID);
    }

    /**
     * Stores the message to the database
     * @param chatID the ID of the Chat that this message should be added to
     * @param message the actual Message that should be added
     */
    public void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException {
        Chat targetChat = dbService.getChatDetails(chatID);
        targetChat.addMessage(message);
        dbService.addMessage(message, targetChat);
    }
}