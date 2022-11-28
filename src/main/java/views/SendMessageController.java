package views;

import entities.Message;
//import entities.TextMessage;
import entities.User;
import user_send_message.MessageInputBoundary;
import user_send_message.MessageOutputBoundary;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class SendMessageController {
    private final MessageInputBoundary messageInputBoundary;
//    private final MessageOutputBoundary messageOutputBoundary;

    public SendMessageController(MessageInputBoundary messageInputBoundary) {
        this.messageInputBoundary = messageInputBoundary;
//        this.messageOutputBoundary = messageOutputBoundary;
    }

    public void createChat(int chatID) throws ExecutionException, InterruptedException {
        this.messageInputBoundary.createChat(chatID);
    }

    /** Sends the created message
     *
     * @param id
     * @param message
     * @param receiver
     * @param recipient
     * @param timestamp
     */
    public void sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException {
        this.messageInputBoundary.sendMessage(chatID, message, senderID, receiverID, timestamp);
    }

}