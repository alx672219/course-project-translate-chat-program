package contact_usecases.add_contact_use_case;

import gateways.UserAddContactGateway;
import gateways.UserAddContactPersistance;

import java.util.concurrent.ExecutionException;

public class AddContactInteractor implements AddContactInputBoundary{

    @Override
    public void addContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        UserAddContactGateway userAddContactGateway = new UserAddContactPersistance();
        userAddContactGateway.addContact(userID, contactID);
    }
}
