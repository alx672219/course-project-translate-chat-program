package views;

import contact_usecases.add_contact_use_case.AddContactInputBoundary;
import contact_usecases.delete_contact_use_case.DeleteContactInputBoundary;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ContactController {
    private final AddContactInputBoundary addContactInputBoundary;
    private final DeleteContactInputBoundary deleteContactInputBoundary;

    public ContactController(AddContactInputBoundary addContactInputBoundary,
                             DeleteContactInputBoundary deleteContactInputBoundary) {
        this.addContactInputBoundary = addContactInputBoundary;
        this.deleteContactInputBoundary = deleteContactInputBoundary;
    }

    public void addContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        this.addContactInputBoundary.addContact(userID, contactID);
    }

    public void deleteContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        this.deleteContactInputBoundary.deleteContact(userID, contactID);
    }

}
