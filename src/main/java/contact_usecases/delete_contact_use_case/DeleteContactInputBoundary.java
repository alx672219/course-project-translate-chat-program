package contact_usecases.delete_contact_use_case;


import java.util.concurrent.ExecutionException;

public interface DeleteContactInputBoundary {
    /**
     * Add a contact
     */

    DeleteContactResponse deleteContact(DeleteContactData data);
}