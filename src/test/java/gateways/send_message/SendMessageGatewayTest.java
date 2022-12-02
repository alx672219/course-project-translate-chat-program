package gateways.send_message;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import entities.User;
import gateways.SendMessageGatewayImplementation;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SendMessageGatewayTest {
    private final SendMessageGatewayImplementation gateway = new SendMessageGatewayImplementation();
    DBInitializer dbInitializer = new DBInitializer();

    @Test
    void getUserDetails() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        User expectedUser = gateway.getUserDetails(1);

        DocumentReference userRef = dbFirestore.collection("users").document("id" + 1);

        Map<String, Object> userData = userRef.get().get().getData();

        ArrayList<Long> contacts = (ArrayList<Long>) userData.get("contacts");

        ArrayList<Long> expectedContacts = new ArrayList<Long>();
        expectedContacts.add(2L);
        expectedContacts.add(3L);


        String default_lang = (String) userData.get("default_lang");
        String email = (String) userData.get("email");
        String userName = (String) userData.get("name");
        String password = (String) userData.get("password");
        int userID = Integer.parseInt((String.valueOf(userData.get("user_id"))));

        User actualUser = new User(userName, default_lang, email, password);
        actualUser.setUser_id(userID);
        actualUser.setContacts(contacts);

        assertTrue(new ReflectionEquals(expectedUser).matches(actualUser));
    }


}
