package controllers;

import entities.Message;
//import entities.TextMessage;
import user_send_message.MessageInputBoundary;
import user_send_message.SendMessageResponse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class SendMessageController {
    private final MessageInputBoundary messageInputBoundary;
//    private final MessageOutputBoundary messageOutputBoundary;

    public SendMessageController(MessageInputBoundary messageInputBoundary) {
        this.messageInputBoundary = messageInputBoundary;
//        this.messageOutputBoundary = messageOutputBoundary;
    }



    /** Sends the created message
     *
     * @param chatID ID of chat that message is sent in
     * @param message actual text of the message
     * @param receiverID ID of the receiver
     * @param senderID ID of the sender
     * @param timestamp timestamp of the message
     */
    public SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
        return this.messageInputBoundary.sendMessage(chatID, message, senderID, receiverID, timestamp);
    }

    public ArrayList<Message> getAllMessages(int chatID) {
        return this.messageInputBoundary.getAllMessages(chatID);
    }

    public int getChatIDByUsers(int userID, int contactID) {
        return this.messageInputBoundary.getChatIDByUsers(userID, contactID);
    }

}