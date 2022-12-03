package user_send_message;


import entities.Message;


import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public interface MessageInputBoundary {
    /**
     * Creates and sends a message
     * @param senderID needed to create message instance
     * @return the response from the interactor
     */
    SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException;

    /**
     * Fetches all the messages in a specific chat ID
     * @param chatID
     * @return List of all messages in a chat
     */
    ArrayList<Message> getAllMessages(int chatID);

    /**
     * Fetches the chatID given two user IDs
     * @param userID
     * @param contactID
     * @return The chatID of the chat used by two users
     */
    int getChatIDByUsers(int userID, int contactID);
}