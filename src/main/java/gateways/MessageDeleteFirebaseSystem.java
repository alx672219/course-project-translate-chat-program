package gateways;
import message_edit_delete_use_case.MessageDeleteData;
import message_edit_delete_use_case.MessageDeleteGateway;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.DocumentSnapshot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MessageDeleteFirebaseSystem implements MessageDeleteGateway {
    @Override
    public void delete(MessageDeleteData data) {
        int messageID = data.getMessageID();
        int chatID = data.getChatID();
        Firestore dbFireStore = FirestoreClient.getFirestore();
        DocumentReference messageRef = dbFireStore.collection("messages").document("id"+messageID);
        DocumentReference chatRef = dbFireStore.collection("chats").document("id"+chatID);
        messageRef.delete();

        try {
            DocumentSnapshot chatDoc = chatRef.get().get();
            Map<String,Object> chatData = chatDoc.getData();
            List<DocumentReference> messages = (List<DocumentReference>) chatData.get("messages");
            messages.remove(messageRef);
            chatRef.set(chatData);


        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


}
