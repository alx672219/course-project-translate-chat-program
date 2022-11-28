package user_send_message;

import entities.Message;
import entities.User;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SendMessageGateway {
    void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException;

    User getUserDetails(int userID) throws ExecutionException, InterruptedException;

    List<Integer> getAllMessages();

    ArrayList<Message> getMessagesByChat(int chatID);

    int getChatIDByUsers(int userID, int contactID);
}
