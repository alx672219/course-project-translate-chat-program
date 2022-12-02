package contact_usecases.add_contact_use_case;

import contact_usecases.delete_contact_use_case.DeleteContactResponse;
import gateways.UserAddContactPersistance;

import java.util.concurrent.ExecutionException;

public class AddContactInteractor implements AddContactInputBoundary {

    UserAddContactGateway gateway;
    AddContactOutputBoundary presenter;

    /**
     * Constructor for AddContactInteractor.
     * @param gateway database to access Users
     * @param presenter presenter to let UI know what it should do
     */
    public AddContactInteractor(UserAddContactGateway gateway, AddContactOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    /**
     * Add contactIDs that match data and return a AddContactResponse object.
     * @param data data to match messages with
     * @return AddContactResponse object indicating what to show the user
     */
    @Override
    public AddContactResponse addContact(AddContactData data) throws ExecutionException, InterruptedException {
        if (data.getContactID() == data.getUserID()) {
            return presenter.prepareFailView("You can't add yourself as a contact!");
        } else if (gateway.getUserDetails(data.getContactID()) == null) {
            return presenter.prepareFailView("There is no user with this ID.");
        } else if (gateway.getUserDetails(data.getUserID()).getContacts().contains((long) data.getContactID())) {
            return presenter.prepareFailView("You already have a contact with this ID.");
        }
        gateway.addContact(data.getUserID(), data.getContactID());
        AddContactResponse response = new AddContactResponse(data.getUserID(), (long) data.getContactID(), true, null);
        return presenter.prepareSuccessView(response);
    }
}
