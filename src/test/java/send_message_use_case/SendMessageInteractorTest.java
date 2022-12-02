package send_message_use_case;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import entities.Message;
import entities.User;
import gateways.SendMessageGatewayImplementation;
import message_edit_delete_use_case.MessageDeleteData;
import org.junit.jupiter.api.Test;
import user_send_message.MessageInteractor;
import services.DBInitializer;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendMessageInteractorTest {
    private final SendMessageGatewayImplementation gateway = new SendMessageGatewayImplementation();

    DBInitializer dbInitializer = new DBInitializer();

    MessageInteractor messageInteractor = new MessageInteractor(gateway);

    @Test
    void sendMessage() throws FileNotFoundException, ExecutionException, InterruptedException, ParseException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference chatref = dbFirestore.collection("chats").document("id"+0);
        List<DocumentReference> expectedMessages = (List<DocumentReference>) chatref.get().get().getData().get("messages");
        int expectedSize = expectedMessages.size();

        messageInteractor.sendMessage(0, "unit test", 3, 4, new Date());


        List<DocumentReference> messagesAfterSend = (List<DocumentReference>) chatref.get().get().getData().get("messages");
        int actualSize = messagesAfterSend.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getChatIDByUsers() throws FileNotFoundException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();

        int actualChatID = messageInteractor.getChatIDByUsers(1, 3);
        int expectedChatID = 8;

        assertEquals(actualChatID, expectedChatID);
    }

    @Test
    void getAllMessages() throws FileNotFoundException, ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference chatref = dbFirestore.collection("chats").document("id"+9);
        List<DocumentReference> expectedMessages = (List<DocumentReference>) chatref.get().get().getData().get("messages");

        int expectedSize = expectedMessages.size();
        int actualSize = messageInteractor.getAllMessages(9).size();

        assertEquals(expectedSize, actualSize);

    }
}