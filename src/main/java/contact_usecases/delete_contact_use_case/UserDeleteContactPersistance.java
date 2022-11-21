package contact_usecases.delete_contact_use_case;

import entities.User;
import services.DBService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class UserDeleteContactPersistance implements UserDeleteContactGateway {
    @Override
    public void deleteContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {
        DBService dbService = new DBService();
        User targetUser = dbService.getUserDetails(userID);
        targetUser.getContacts().remove(contactID);
    }
}
