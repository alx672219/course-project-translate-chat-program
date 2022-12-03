package contact_usecases.delete_contact_use_case;


import java.util.concurrent.ExecutionException;

public interface DeleteContactInputBoundary {
    /**
     * Delete contactIDs that match data and return a DeleteContactResponse object.
     * @param data data to match contactIDs with
     * @return DeleteContactResponse object indicating what to show the user
     */

    DeleteContactResponse deleteContact(DeleteContactData data);
}