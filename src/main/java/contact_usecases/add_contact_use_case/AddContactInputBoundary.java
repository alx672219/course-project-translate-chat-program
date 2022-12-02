package contact_usecases.add_contact_use_case;


import contact_usecases.delete_contact_use_case.DeleteContactResponse;

import java.util.concurrent.ExecutionException;

public interface AddContactInputBoundary {
    /**
     * Add a contact
     */

    AddContactResponse addContact(AddContactData data) throws ExecutionException, InterruptedException;
}
