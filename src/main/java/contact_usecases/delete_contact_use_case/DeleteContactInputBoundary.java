package contact_usecases.delete_contact_use_case;


import java.util.concurrent.ExecutionException;

public interface DeleteContactInputBoundary {
    /**
     * Add a contact
     */

    void deleteContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException;
}