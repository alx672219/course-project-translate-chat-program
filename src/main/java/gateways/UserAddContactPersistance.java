package gateways;

import entities.User;
import gateways.UserAddContactGateway;
import services.DBService;

import java.util.concurrent.ExecutionException;

public class UserAddContactPersistance implements UserAddContactGateway {
    @Override
    public void addContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        DBService dbService = new DBService();
        User targetUser = dbService.getUserDetails(Integer.parseInt(String.valueOf(userID)));
        dbService.addContact(targetUser, contactID);
    }
}
