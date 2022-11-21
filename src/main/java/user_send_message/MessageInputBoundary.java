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
     * @param data needed to create message instance
     * @return the message created
     */

    void createChat(int chatID) throws ExecutionException, InterruptedException;

    void sendMessage(int chatID, int id, String message, User receiver, User recipient, Date timestamp) throws ExecutionException, InterruptedException, ParseException;
}
