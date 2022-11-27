package user_send_message;

import entities.Chat;
//import entities.TextMessage;
import entities.User;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public interface MessageInputBoundary {
    /**
     * Creates a message
     *
     * @param senderID needed to create message instance
     * @return the message created
     */

    SendMessageResponse sendMessage(int chatID, String message, int senderID, int receiverID, Date timestamp) throws ExecutionException, InterruptedException, ParseException;
}