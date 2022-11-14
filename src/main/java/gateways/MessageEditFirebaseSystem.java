package gateways;

import message_edit_delete_use_case.MessageEditData;
import message_edit_delete_use_case.MessageEditGateway;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.DocumentSnapshot;
import org.apache.arrow.flatbuf.Int;

import java.util.concurrent.ExecutionException;

public class MessageEditFirebaseSystem implements MessageEditGateway {
    @Override
    public void edit(MessageEditData data) {
        String messageID = "id" + data.getID();
        String text = data.getEditText();
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference messageDocumentReference = dbFireStore.collection("messages").document(messageID);
        try {
            DocumentSnapshot messageDocument = messageDocumentReference.get().get();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
