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
        dbService = new DBService();
    }

    @Override
    public List<Integer> deleteContact(Integer userID, Integer contactID) {
        User targetUser;
        try {
            targetUser = dbService.getUserDetails(userID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            dbService.deleteContact(targetUser, Long.valueOf(contactID));
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Integer> ids = new ArrayList<>();
        ids.add(userID);
        ids.add(contactID);
        return ids;
    }
}
