package user_send_message;

import entities.Chat;
import entities.Message;

import java.text.ParseException;
import java.util.concurrent.ExecutionException;

public interface SendMessageGateway {
    public void addChat(Chat chat) throws ExecutionException, InterruptedException;

    public void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException;
}
