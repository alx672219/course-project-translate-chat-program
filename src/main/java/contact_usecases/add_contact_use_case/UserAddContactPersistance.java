package contact_usecases.add_contact_use_case;

import entities.User;
import services.DBService;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class UserAddContactPersistance implements UserAddContactGateway {
    @Override
    public void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {
        DBService dbService = new DBService();
        User targetUser = dbService.getUserDetails(userID);
//        targetUser.getContacts().add(contactID);
    }
}
