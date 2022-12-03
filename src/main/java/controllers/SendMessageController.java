package controllers;

//import entities.TextMessage;
import user_send_message.MessageInputBoundary;
import user_send_message.SendMessageResponse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SendMessageController {
    /**
     * The message interactor
     */
    private final MessageInputBoundary messageInputBoundary;

    public SendMessageController(MessageInputBoundary messageInputBoundary) {
        this.messageInputBoundary = messageInputBoundary;
    }

    /**
     * Sends the created message
     * @param chatID ID of chat that message is sent in
     * @param message actual text of the message
     * @param receiverID ID of the receiver
     * @param senderID ID of the sender
     * @param timestamp timestamp of the message
     * @return the response given by the interactor
     */
    public SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
        return this.messageInputBoundary.sendMessage(chatID, message, senderID, receiverID, timestamp);
    }

    /**
     * Retrieves all the message in a certain chat
     * @param chatID The ID of the chat to fetch all messages from
     * @return ArrayList of messages fetched from the target chatID
     */
    public ArrayList<Map<String, Object>> getAllMessages(int chatID) {
        return this.messageInputBoundary.getAllMessages(chatID);
    }

    /**
     * Retrieves the chat ID corresponding to a sender and receiver user
     * @param userID ID of the main user
     * @param contactID ID of the other user
     * @return The chat ID of the user and contactID chat
     */
    public int getChatIDByUsers(int userID, int contactID) {
        return this.messageInputBoundary.getChatIDByUsers(userID, contactID);
    }

}