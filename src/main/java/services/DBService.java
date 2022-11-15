package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import entities.Chat;
import entities.Message;
import entities.User;

import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DBService {
    /**
     *
     * @param user
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docName = "id" + String.valueOf(user.getUser_id());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(docName).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        String documentName = "id" + String.valueOf(userID);
        DocumentReference documentReference = dbFirestore.collection("users").document(documentName);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        // Extract DocumentSnapShot from ApiFuture object
        DocumentSnapshot document = future.get();

        User user = null;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        } else {
            return null;
        }

    }

    public Chat getChatDetails(int chatID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String documentName = "id" + String.valueOf(chatID);
        DocumentReference documentReference = dbFirestore.collection("chats").document(documentName);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Chat chat = null;
        if (document.exists()) {
            chat = document.toObject(Chat.class);
            return chat;
        } else {
            return null;
        }
    }


    public void addMessage(Message message) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", String.valueOf(message.getId()));

        String receiverID = "id" + String.valueOf(message.getReceiver().getUser_id());
        String recipientID = "id" + String.valueOf(message.getRecipient().getUser_id());

        DocumentReference receiverRef = dbFirestore.collection("users").document(receiverID);
        DocumentReference recipientRef = dbFirestore.collection("users").document(recipientID);

        docData.put("message", message.getMessage());
        docData.put("receiver", receiverRef);
        docData.put("recipient", recipientRef);
        docData.put("timestamp", message.getTimestamp());

        String docName = "id" + String.valueOf(message.getId());
        DocumentReference docRef = dbFirestore.collection("messages").document(docName);

        ApiFuture<WriteResult> collectionsApiFuture = docRef.set(docData);
        collectionsApiFuture.get();
    }
    public void addChat(Chat chat) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();

        Map<String, Object> docData = new HashMap<>();
        docData.put("id", String.valueOf(chat.getId()));
        ArrayList<DocumentReference> listMessagePaths = new ArrayList<>();

        for (Message message: chat.getMessages()) {
            String messageID = "id" + String.valueOf(message.getId());
            DocumentReference messageRef = dbFireStore.collection("messages").document(messageID);
            listMessagePaths.add(messageRef);
        }

        docData.put("messages", listMessagePaths);
        String docName = "id" + String.valueOf(chat.getId());
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("chats").document(docName).set(docData);
        collectionsApiFuture.get();
    }
}
