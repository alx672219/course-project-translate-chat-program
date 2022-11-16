package services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.storage.v2.Object;
import entities.User;

import javax.swing.text.Document;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class DBService {
    public String saveUserDetails(User user) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        String docName = "id" + String.valueOf(user.getUser_id());
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(docName).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }


    public User getUserDetails(int userID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        // First get document reference from specified collection and document
        // Then get the APIFuture of that document
        String documentName = "id" + String.valueOf(userID);
        DocumentReference documentReference = dbFirestore.collection("users").document(documentName);
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

    public void addContact(User user, Long contactID) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        //System.out.println(user.getContacts());
        String docName = "id" + user.getUser_id();
        //System.out.println(docName);
        user.getContacts().add(contactID);
        //System.out.println(user.getContacts());
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        //System.out.println(docRef);
        //System.out.println(user.getContacts());
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
    }


    public void deleteContact(User user, Long contactID) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        //System.out.println(user.getContacts());
        String docName = "id" + user.getUser_id();
        //System.out.println(docName);
        //System.out.println(user.getContacts().getClass().getName());
        //System.out.println(user.getContacts());
        user.getContacts().remove(contactID);
        //System.out.println(user.getContacts());
        DocumentReference docRef = dbFireStore.collection("users").document(docName);
        //System.out.println(docRef);
        //System.out.println(user.getContacts());
        ApiFuture<WriteResult> future = docRef.update("contacts", user.getContacts());
        WriteResult result = future.get();
    }


}
