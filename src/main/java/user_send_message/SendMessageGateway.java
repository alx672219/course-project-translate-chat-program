package user_send_message;

import entities.Message;
import entities.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Interface for the gateway to send messages
 */
public interface SendMessageGateway {
    /**
     * Attempts to send a message and persist it to the database
     * @param chatID ID of the chat
     * @param message message to send
     * @throws ExecutionException if data cannot be retrieved from database
     * @throws InterruptedException if the process of getting data is interrupted
     * @throws ParseException if timestamp cannot be parsed
     */
    void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException;

    /**
     * Gets the user instance of a certain user id
     * @param userID ID of the user
     * @return The User instance corresponding to a user id
     * @throws ExecutionException if data cannot be retrieved from database
     * @throws InterruptedException if the process of getting data is interrupted
     */
    User getUserDetails(int userID) throws ExecutionException, InterruptedException;

    /**
     * Gets all the messages in the database
     * @return A list of all messages in the database
     */
    List<Integer> getAllMessages();

    /**
     * Gets all the messages corresponding to a chat
     * @param chatID ID of the chat
     * @return A list of all the messages corresponding to a chat
     */
    ArrayList<Message> getMessagesByChat(int chatID);

    /**
     * Gets a chat based on two users ids
     * @param userID ID of the main user
     * @param contactID ID of the other user
     * @return The chatID given two user IDs
     */
    int getChatIDByUsers(int userID, int contactID);
}
