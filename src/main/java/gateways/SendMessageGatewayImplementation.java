package gateways;

import entities.Chat;
import entities.Message;
import services.DBService;
import user_send_message.SendMessageGateway;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SendMessageGatewayImplementation implements SendMessageGateway {
    /** Gets Chat corresponding to chatID
     *
     * @param chatID
     * @return Chat with id of the passed parameter chatID
     */
    DBService dbService;

    public SendMessageGatewayImplementation() {
        dbService = new DBService();
    }

    @Override
    public void addChat(Chat chat) throws ExecutionException, InterruptedException {
        dbService.addChat(chat);
    }

    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        return dbService.getUserDetails(userID);
    }

    public List<Integer> getAllMessages() {
        List<Integer> messageIDs = null;

        try {
            messageIDs = dbService.getAllMessageIDs();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return messageIDs;
    }


    /** Stores the message to the database
     *
     * @param chatID
     * @param message
     */
    public void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException, ParseException {
        Chat targetChat = dbService.getChatDetails(chatID);
        targetChat.addMessage(message);
        dbService.addMessage(message, targetChat);
//        dbService.addMessage(message, targetChat);


        //                User sender = new User("Billy", "en", "billy@gmail.com", "123", 6);
//                User receiver = new User("Howard", "en", "howard@gmail.com", "123", 7);
//
    }
}