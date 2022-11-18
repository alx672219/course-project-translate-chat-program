package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DBService {
    private final Firestore db;

    public DBService() {
        db = FirestoreClient.getFirestore();
    }

    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        String docName = "id" + String.valueOf(user.getUser_id());
        ApiFuture<WriteResult> collectionsApiFuture = db.collection("users").document(docName).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        String docName = "id" + String.valueOf(userID);
        DocumentReference documentReference = db.collection("users").document(docName);
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
}
