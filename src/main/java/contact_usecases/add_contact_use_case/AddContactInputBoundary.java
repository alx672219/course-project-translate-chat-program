package contact_usecases.add_contact_use_case;


import contact_usecases.delete_contact_use_case.DeleteContactResponse;

import java.util.concurrent.ExecutionException;

public interface AddContactInputBoundary {
    /**
     * Add contactIDs that match data and return a AddContactResponse object.
     * @param data data to match contactIDs with
     * @return AddContactResponse object indicating what to show the user
     */

    AddContactResponse addContact(AddContactData data) throws ExecutionException, InterruptedException;
}
