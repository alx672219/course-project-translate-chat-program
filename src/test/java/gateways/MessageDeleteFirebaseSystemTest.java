package gateways;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import message_edit_delete_use_case.MessageDeleteData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class MessageDeleteFirebaseSystemTest {
    private final MessageDeleteFirebaseSystem gateway = new MessageDeleteFirebaseSystem();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void delete() throws FileNotFoundException, ExecutionException, InterruptedException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        gateway.delete(new MessageDeleteData(5, 4));
        DocumentReference chatref = dbFirestore.collection("chats").document("id"+4);
        assertEquals(0, ( (List<DocumentReference>) Objects.requireNonNull(chatref.get().get().getData()).get("messages")).size());
    }

    @AfterEach
    void tearDown() {

    }
}

