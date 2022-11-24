package gateways;

import contact_usecases.add_contact_use_case.UserAddContactGateway;
import entities.User;
import services.DBService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class UserAddContactPersistance implements UserAddContactGateway {
    DBService dbService;

    public UserAddContactPersistance() {
        this.dbService = new DBService();
    }

    @Override
    public void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {

        User targetUser = dbService.getUserDetails(userID);
        dbService.addContact(targetUser, Long.valueOf(contactID));

    }

    @Override
    public User getUserDetails(int userID) {
        try {
            return dbService.getUserDetails(userID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
