package gateways;

import contact_usecases.delete_contact_use_case.UserDeleteContactGateway;
import entities.User;
import services.DBService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserDeleteContactPersistance implements UserDeleteContactGateway {
    DBService dbService;
    public UserDeleteContactPersistance() {
        dbService = DBService.getInstance();
    }

    @Override
    public List<Integer> deleteContact(Integer userID, Integer contactID) {
        User mainUser;
        User contactUser;
        try {
            mainUser = dbService.getUserDetails(userID);
            contactUser = dbService.getUserDetails(contactID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            dbService.deleteContact(mainUser, Long.valueOf(contactID));
            dbService.deleteContact(contactUser, Long.valueOf(userID));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        dbService.deleteChat(userID, contactID);
        List<Integer> ids = new ArrayList<>();
        ids.add(userID);
        ids.add(contactID);
        return ids;
    }

    public User getUserDetails(int userID) {
        try {
            return dbService.getUserDetails(userID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
