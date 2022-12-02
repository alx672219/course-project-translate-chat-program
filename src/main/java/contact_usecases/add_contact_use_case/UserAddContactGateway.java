package contact_usecases.add_contact_use_case;

import entities.User;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface UserAddContactGateway {

    /**
     * Adds contactIDs in database that match userID in data
     * @param userID AddContactData object that tells method which userID's contact is
     * @param contactID AddContactData object that tells method which contactID to add
     */
    void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException;

    /**
     * Gets userIDs that match userID in data
     * @param userID AddContactData object that tells method which userID to look for
     * @return userIDs that match data
     */
    User getUserDetails(int userID);


}
