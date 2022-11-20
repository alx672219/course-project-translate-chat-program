package contact_usecases.add_contact_use_case;


import java.util.concurrent.ExecutionException;

public interface AddContactInputBoundary {
    /**
     * Add a contact
     */

    void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException;
}
