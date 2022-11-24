package views;

import contact_usecases.delete_contact_use_case.DeleteContactData;
import contact_usecases.delete_contact_use_case.DeleteContactInputBoundary;
import contact_usecases.delete_contact_use_case.DeleteContactResponse;

public class DeleteContactController {
    DeleteContactInputBoundary interactor;

    public DeleteContactController(DeleteContactInputBoundary interactor) {
        this.interactor = interactor;
    }

    public DeleteContactResponse deleteContact(DeleteContactData data) {
        return this.interactor.deleteContact(data);
    }
}
