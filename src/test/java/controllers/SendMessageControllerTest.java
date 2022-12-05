package controllers;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import gateways.SendMessageGatewayImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import user_send_message.MessageInputBoundary;
import user_send_message.MessageInteractor;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendMessageControllerTest {
    private SendMessageController controller;
    DBInitializer initializer = new DBInitializer();

    @BeforeEach
    void setUp() {
        SendMessageGatewayImplementation gateway = new SendMessageGatewayImplementation();
        MessageInputBoundary interactor = new MessageInteractor(gateway);
        this.controller = new SendMessageController(interactor);
    }

    @Test
    void sendMessage() throws ExecutionException, InterruptedException, ParseException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference chatref = dbFirestore.collection("chats").document("id"+0);

        List<DocumentReference> expectedMessages = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");
        int expectedSize = expectedMessages.size() + 1;

        controller.sendMessage(0, "unit test", 3, 4, new Date());


        List<DocumentReference> messagesAfterSend = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");
        int actualSize = messagesAfterSend.size() + 1;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getChatIDByUsers() throws FileNotFoundException {
        initializer.init();
        int actualChatID = controller.getChatIDByUsers(1, 3);
        int expectedChatID = 8;

        assertEquals(actualChatID, expectedChatID);
    }

    @Test
    void getAllMessages() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference chatref = dbFirestore.collection("chats").document("id"+9);
        List<DocumentReference> expectedMessages = (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages");

        int expectedSize = expectedMessages.size();
        int actualSize = controller.getAllMessages(9).size();

        assertEquals(expectedSize, actualSize);
    }
}