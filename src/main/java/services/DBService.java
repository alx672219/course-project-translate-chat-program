package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import com.google.firestore.v1.Write;
import entities.User;

import java.util.HashMap;
import java.util.Map;

import entities.User;

import javax.swing.text.Document;
import java.util.HashMap;
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
import java.util.ArrayList;
import java.util.List;
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
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String documentName = "id" + String.valueOf(userID);
        DocumentReference documentReference = dbFirestore.collection("users").document(documentName);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        // Extract DocumentSnapShot from ApiFuture object
        DocumentSnapshot document = future.get();

        User user;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        } else {
            return null;
        }

    }

    public void updateDefaultLang(User user, String newDefaultLang) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setDefaultLang(newDefaultLang);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("default_lang", user.getDefaultLang());
    }
    public void updateName(User user, String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setName(name);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("name", user.getName());
    }
    public void updatePassword(User user, String password) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setPassword(password);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("password", user.getPassword());
    }

    public boolean existName(User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference usersReference = dbFirestore.collection("users");
        String userID = "id" + user.getUser_id();

        try {
            for (DocumentReference ref : usersReference.listDocuments()) {
                if (ref.get().get().getData().get("user_id").equals(user.getUser_id())) {
                    return false;
                }
            }
            return true;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
     * Returns a list of all the user ids that are currently registered for the app.
     * @return a list of all user ids currently registered for the app.
     * @throws ExecutionException If firebase cannot execute properly
     * @throws InterruptedException If the firebase request gets interrupted
     */
    public List<Integer> getAllUserId() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ArrayList<Integer> ret = new ArrayList<>();
        // asynchronously retrieve all documents
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot query : documents) {
            int uid = Integer.parseInt(query.get("user_id").toString());
            ret.add(uid);
        }
        return ret;
    }

    /**
     * Returns the User with a given username, or returns null if no User has this username.
     */
    public User getByUsername(String username) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference users = db.collection("users");
        // Create a query against the collection.
        Query query = users.whereEqualTo("name", username);
        // retrieve  query results asynchronously using query.get()
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        // Usernames are unique so the querySnapshot should only contain 1 object
        // Create a user object using that information and return the User
        if (!querySnapshot.get().getDocuments().isEmpty()) {
            return querySnapshot.get().getDocuments().get(0).toObject(User.class);
        }
        return null;
    }

    public void addContact(User user, Long contactID) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        //System.out.println(user.getContacts());
        String docName = "id" + user.getUser_id();
        //System.out.println(docName);
        user.getContacts().add(contactID);
        //System.out.println(user.getContacts());
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        //System.out.println(docRef);
        //System.out.println(user.getContacts());
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
    }


    public void deleteContact(User user, Long contactID) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        //System.out.println(user.getContacts());
        String docName = "id" + user.getUser_id();
        //System.out.println(docName);
        //System.out.println(user.getContacts().getClass().getName());
        //System.out.println(user.getContacts());
        user.getContacts().remove(contactID);
        //System.out.println(user.getContacts());
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        //System.out.println(docRef);
        //System.out.println(user.getContacts());
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
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
