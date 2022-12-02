package contact_usecases.add_contact_use_case;

import entities.User;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface UserAddContactGateway {
    void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException;
    User getUserDetails(int userID);


}
