package user_send_message;

import entities.Chat;
import entities.Message;
import entities.User;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface SendMessageGateway {
    public void addChat(Chat chat) throws ExecutionException, InterruptedException;

    public void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException;

    public User getUserDetails(int userID) throws ExecutionException, InterruptedException;

    public List<Integer> getAllMessages();
}
