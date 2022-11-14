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


    /** Stores the message to the database
     *
     * @param chatID
     * @param message
     */
    public Chat sendMessage(int chatID) throws ExecutionException, InterruptedException {
        DBService dbService = new DBService();
        Chat targetChat = dbService.getChatDetails(chatID);
        return targetChat;
        // Accesses database to

    }

}
