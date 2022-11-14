package gateways;

import entities.User;
import services.DBService;
import user_register_use_case.CreationData;
import user_register_use_case.UserRegistrationGateway;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserRegistrationFirebaseSystem implements UserRegistrationGateway {

    /**
     * Creates a new user using the given data and adds them to Firebase.
     * @param data the data with which to create the new user
     * @return whether the operation was successful
     */
    @Override
    public boolean create(CreationData data) {
        DBService db = new DBService();
        List<Integer> ids;
        try {
            ids = db.getAllUserId();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getMessage());
        }
        int id = Collections.max(ids) + 1;

        // Create the new user
        User user = new User(data.getUsername(), data.getDefault_lang(), data.getEmail(), data.getPassword());
        user.setUser_id(id);
        System.out.println(user);
        // Save the new user to database
        try {
            db.saveUserDetails(user);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
