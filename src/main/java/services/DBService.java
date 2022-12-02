package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.Write;
import entities.User;

import java.util.HashMap;
import java.util.Map;

import entities.Chat;
import entities.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DBService {

    /** Write the data of a given user to Firestore.
     *
     * @param user The User to write to the database
     * @return The time at which the data was written
     * @throws ExecutionException If execution is interrupted
     * @throws InterruptedException If execution is interrupted
     */
    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docName = "id" + user.getUser_id();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(docName).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    /**
     * Returns the given User object corresponding to the given user id if
     * one exists, otherwise returns null.
     *
     * @param userID The user id which corresponds to the user.
     * @return The User object corresponding to the given user id
     * @throws ExecutionException If execution is interrupted
     * @throws InterruptedException If execution is interrupted
     */
    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String documentName = "id" + userID;
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

    /**
     * Change user's default language to the new language
     * @param user the user whose default language is to be changed
     * @param newDefaultLang the new language to change to
     */
    public void updateDefaultLang(User user, String newDefaultLang) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setDefault_lang(newDefaultLang);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("default_lang", user.getDefault_lang());
    }

    /**
     * Change user's name to the new name
     * @param user the user whose name is to be changed
     * @param name the new name to change to
     */
    public void updateName(User user, String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setName(name);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("name", user.getName());
    }

    /**
     * Change user's password to the new password
     * @param user the user whose password is to be changed
     * @param password the new password to change to
     */
    public void updatePassword(User user, String password) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docInfo = "id" + user.getUser_id();
        user.setPassword(password);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture future = docRef.update("password", user.getPassword());
    }

    /**
     * Returns true if user's name exist and false otherwise
     * @param user to check user's name
     * @return true or false
     */
    public boolean existName(User user) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        CollectionReference usersReference = dbFirestore.collection("users");

        try {
            for (DocumentReference ref : usersReference.listDocuments()) {
                if (Objects.requireNonNull(ref.get().get().getData()).get("name").equals(user.getName())) {
                    return true;
                }
            }
            return false;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
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
        String docName = "id" + user.getUser_id();
        user.getContacts().add(contactID);
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
    }


    public void deleteContact(User user, Long contactID) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        String docName = "id" + user.getUser_id();
        user.getContacts().remove(contactID);
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
    }

    public Chat getChatDetails(int chatID) throws ExecutionException, InterruptedException, ParseException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String documentName = "id" + chatID;
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

                Integer id = ((Long) messageRef.get().get().getData().get("id")).intValue();
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
            String messageID = "id" + message.getId();
            DocumentReference messageRef = dbFireStore.collection("messages").document(messageID);
            listMessagePaths.add(messageRef);
        }

        docData.put("messages", listMessagePaths);
        String docName = "id" + chat.getId();
        ApiFuture<WriteResult> collectionsApiFuture = dbFireStore.collection("chats").document(docName).set(docData);
        collectionsApiFuture.get();
    }

    public void addMessage(Message message, Chat chat) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        Map<String, Object> docData = new HashMap<>();
        docData.put("id", message.getId());

        String receiverID = "id" + message.getReceiver().getUser_id();
        String recipientID = "id" + message.getRecipient().getUser_id();

        DocumentReference receiverRef = dbFirestore.collection("users").document(receiverID);
        DocumentReference recipientRef = dbFirestore.collection("users").document(recipientID);

        docData.put("message", message.getMessage());
        docData.put("receiver", receiverRef);
        docData.put("recipient", recipientRef);
        docData.put("timestamp", message.getTimestamp());

        String docName = "id" + message.getId();
        DocumentReference messageRef = dbFirestore.collection("messages").document(docName);

        ApiFuture<WriteResult> collectionsApiFuture = messageRef.set(docData);
        collectionsApiFuture.get();

        // Add the message to the chat
        String chatDocName = "id" + chat.getId();
        DocumentReference chatRef = dbFirestore.collection("chats").document(chatDocName);

        ApiFuture<WriteResult> arrayUnion = chatRef.update("messages", FieldValue.arrayUnion(messageRef));
    }
}
