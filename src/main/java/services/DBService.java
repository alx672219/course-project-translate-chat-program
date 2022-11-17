package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DBService {
    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(user.getName()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        DocumentReference documentReference = dbFirestore.collection("users").document(String.valueOf(userID));
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        // Extract DocumentSnapShot from ApiFuture object
        DocumentSnapshot document = future.get();

        User user = null;
        if (document.exists()) {
            user = document.toObject(User.class);
            return user;
        } else {
            return null;
        }

    }

    public void updateDefaultLang(User user, String newDefaultLang) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // System.out.println(user.getDefaultLang());
        String docInfo = "id" + user.getUser_id();
        user.setDefaultLang(newDefaultLang);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture<WriteResult> future = docRef.update("users", user.getDefaultLang());
        // System.out.println(user.getDefaultLang());
    }
    public void updateName(User user, String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // System.out.println(user.getName());
        String docInfo = "id" + user.getUser_id();
        user.setName(name);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture<WriteResult> future = docRef.update("users", user.getName());
        // System.out.println(user.getName());
    }
    public void updatePassword(User user, String password) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // System.out.println(user.getPassword());
        String docInfo = "id" + user.getUser_id();
        user.setPassword(password);
        DocumentReference docRef = dbFirestore.collection("users").document(docInfo);
        ApiFuture<WriteResult> future = docRef.update("users", user.getPassword());
        // System.out.println(user.getPassword());
    }
}