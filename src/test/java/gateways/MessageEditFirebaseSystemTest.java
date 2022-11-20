package gateways;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import message_edit_delete_use_case.MessageEditData;
import org.junit.jupiter.api.Test;
import services.DBInitializer;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class MessageEditFirebaseSystemTest {
    private final MessageEditFirebaseSystem gateway = new MessageEditFirebaseSystem();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void edit() throws FileNotFoundException, ExecutionException, InterruptedException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        gateway.edit(new MessageEditData("bye", 3));
        DocumentReference messageref = dbFirestore.collection("messages").document("id"+3);
        assertEquals("bye", (String) messageref.get().get().getData().get("message"));
    }
}