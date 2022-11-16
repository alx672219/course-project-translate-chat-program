package gateways;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import entities.Chat;
import entities.Message;
import entities.User;
import services.DBService;

import java.util.concurrent.ExecutionException;

public class SendMessageGateway {
    /** Gets Chat corresponding to chatID
     *
     * @param chatID
     * @return Chat with id of the passed parameter chatID
     */
    DBService dbService;

    public SendMessageGateway() {
        dbService = new DBService();
    }

    public void addChat(Chat chat) throws ExecutionException, InterruptedException {
        dbService.addChat(chat);
    }


    /** Stores the message to the database
     *
     * @param chatID
     * @param message
     */
    public void sendMessage(int chatID, Message message) throws ExecutionException, InterruptedException {
        Chat targetChat = dbService.getChatDetails(chatID);
        targetChat.addMessage(message);
        dbService.addMessage(message);
    }

}
