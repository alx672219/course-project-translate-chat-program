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
     * @param chatID
     * @param message
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws ParseException
     */
    void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException;

    /**
     * Gets the user instance of a certain user id
     * @param userID
     * @return The User instance corresponding to a user id
     * @throws ExecutionException
     * @throws InterruptedException
     */
    User getUserDetails(int userID) throws ExecutionException, InterruptedException;

    /**
     * Gets all the messages in the database
     * @return A list of all messages in the database
     */
    List<Integer> getAllMessages();

    /**
     * Gets all the messages corresponding to a chat
     * @param chatID
     * @return A list of all the messages corresponding to a chat
     */
    ArrayList<Message> getMessagesByChat(int chatID);

    /**
     * Gets a chat based on two users ids
     * @param userID
     * @param contactID
     * @return The chatID given two user IDs
     */
    int getChatIDByUsers(int userID, int contactID);
}
