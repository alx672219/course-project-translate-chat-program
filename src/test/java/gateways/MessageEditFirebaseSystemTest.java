package gateways;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import message_edit_delete_use_case.MessageEditData;
import org.junit.jupiter.api.Test;
import services.DBInitializer;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class MessageEditFirebaseSystemTest {
    private MessageEditFirebaseSystem gateway = new MessageEditFirebaseSystem();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void edit() throws FileNotFoundException, ExecutionException, InterruptedException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        gateway.edit(new MessageEditData("bye", 3));
        DocumentReference chatref = dbFirestore.collection("chats").document("id"+4);
        assertEquals("bye", ( (List<DocumentReference>)chatref.get().get().getData().get("messages")).size());
    }
}