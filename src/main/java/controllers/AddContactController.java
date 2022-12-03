package controllers;

import contact_usecases.add_contact_use_case.AddContactData;
import contact_usecases.add_contact_use_case.AddContactInputBoundary;
import contact_usecases.add_contact_use_case.AddContactResponse;

import java.util.concurrent.ExecutionException;

public class AddContactController {
    AddContactInputBoundary interactor;

    public AddContactController(AddContactInputBoundary interactor) {
        this.interactor = interactor;
    }

    public AddContactResponse addContact(AddContactData data) {
        try {
            return this.interactor.addContact(data);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
