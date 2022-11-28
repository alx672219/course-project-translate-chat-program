package gateways;

import entities.User;
import gateways.UserDeleteContactGateway;
import services.DBService;

import java.util.concurrent.ExecutionException;

public class UserDeleteContactPersistance implements UserDeleteContactGateway {
    @Override
    public void deleteContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        DBService dbService = new DBService();
        User targetUser = dbService.getUserDetails(Integer.parseInt(String.valueOf(userID)));
        dbService.deleteContact(targetUser, contactID);
    }
}
