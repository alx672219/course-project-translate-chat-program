package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import entities.Chat;
import entities.Message;
import entities.User;

import javax.swing.text.Document;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    public Chat getChatDetails(int chatID) throws ExecutionException, InterruptedException, ParseException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String documentName = "id" + String.valueOf(chatID);
        DocumentReference documentReference = dbFirestore.collection("chats").document(documentName);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Chat chat = null;
        if (document.exists()) {
            // Convert documentReference to class
            ArrayList<DocumentReference> messageRefs = (ArrayList<DocumentReference>) document.getData().get("messages");
            ArrayList<Message> messages = new ArrayList<>();
            for (DocumentReference messageRef: messageRefs) {
                // Get the document reference of the message's receiver object instance
                DocumentReference receiverRef = (DocumentReference) messageRef.get().get().getData().get("receiver");
                // Convert it into a User class
                User receiver = receiverRef.get().get().toObject(User.class);

                // Get the document reference of the message's receiver object instance
                DocumentReference recipientRef = (DocumentReference) messageRef.get().get().getData().get("recipient");
                // Convert it into a User class
                User recipient = recipientRef.get().get().toObject(User.class);

                Integer id = Integer.parseInt((String) messageRef.get().get().getData().get("id"));
                String messageText = (String) messageRef.get().get().getData().get("message");

                String timestamp = messageRef.get().get().getData().get("timestamp").toString();
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(timestamp);

                Message message = new Message(id, messageText, receiver, recipient, date);
                messages.add(message);
            }
            Chat targetChat = new Chat(chatID);
            targetChat.setMessages(messages);
            return targetChat;

        } else {
            return null;
        }
    }

    public List<Integer> getAllMessageIDs() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ArrayList<Integer> ret = new ArrayList<>();
        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("messages").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot query : documents) {
            int uid = Integer.parseInt(Objects.requireNonNull(query.get("id")).toString());
            ret.add(uid);
        }
        return ret;
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

    public void addMessage(Message message, Chat chat) throws ExecutionException, InterruptedException {
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
        DocumentReference messageRef = dbFirestore.collection("messages").document(docName);

        ApiFuture<WriteResult> collectionsApiFuture = messageRef.set(docData);
        collectionsApiFuture.get();

        // Add the message to the chat
        String chatDocName = "id" + String.valueOf(chat.getId());
        DocumentReference chatRef = dbFirestore.collection("chats").document(chatDocName);

        ApiFuture<WriteResult> arrayUnion = chatRef.update("messages", FieldValue.arrayUnion(messageRef));
    }
}
