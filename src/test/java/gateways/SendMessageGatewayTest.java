package gateways;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.firebase.cloud.FirestoreClient;
import entities.Message;
import entities.User;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class SendMessageGatewayTest {
    private final SendMessageGatewayImplementation gateway = new SendMessageGatewayImplementation();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void getUserDetails() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        User expectedUser = gateway.getUserDetails(1);

        DocumentReference userRef = dbFirestore.collection("users").document("id" + 1);

        Map<String, Object> userData = userRef.get().get().getData();

        assert userData != null;
        ArrayList<Long> contacts = (ArrayList<Long>) userData.get("contacts");


        String default_lang = (String) userData.get("default_lang");
        String email = (String) userData.get("email");
        String userName = (String) userData.get("name");
        String password = (String) userData.get("password");
        int userID = Integer.parseInt((String.valueOf(userData.get("user_id"))));

        User actualUser = new User(userName, default_lang, email, password);
        actualUser.setUser_id(userID);
        actualUser.setContacts(contacts);

        assertTrue(new ReflectionEquals(expectedUser).matches(actualUser));
    }

    @Test
    void getAllMessages() throws FileNotFoundException, ExecutionException, InterruptedException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();

        List<QueryDocumentSnapshot> messagesRef =  dbFirestore.collection("messages").get().get().getDocuments();

        int expectedSize = messagesRef.size();
        int actualSize = gateway.getAllMessages().size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getMessagesByChat() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference chatref = dbFirestore.collection("chats").document("id"+9);
        List<DocumentReference> expectedMessages = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");

        int expectedSize = expectedMessages.size();
        int actualSize = gateway.getMessagesByChat(9).size();

        assertEquals(expectedSize, actualSize);

    }

    @Test
    void sendMessage() throws ExecutionException, InterruptedException, ParseException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        List<Integer> messageIDs = gateway.getAllMessages();

        int nextMessageID = Collections.max(messageIDs) + 1;

        User receiver =  gateway.getUserDetails(3);
        User recipient = gateway.getUserDetails(4);

        Message message = new Message(nextMessageID, "hi this is danny", receiver, recipient, new Date());

        DocumentReference chatref = dbFirestore.collection("chats").document("id"+2);
        List<DocumentReference> expectedMessages = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");
        int expectedSize = expectedMessages.size() + 1;


        gateway.sendMessage(2, message);
        chatref = dbFirestore.collection("chats").document("id"+2);
        List<DocumentReference> messagesAfterSend = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");
        int actualSize = messagesAfterSend.size() + 1;

        assertEquals(expectedSize, actualSize);
    }

}
