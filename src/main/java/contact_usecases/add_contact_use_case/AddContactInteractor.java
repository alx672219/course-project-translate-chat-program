package contact_usecases.add_contact_use_case;

import java.util.concurrent.ExecutionException;

public class AddContactInteractor implements AddContactInputBoundary{

    @Override
    public void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {
        UserAddContactGateway userAddContactGateway = new UserAddContactPersistance();
        userAddContactGateway.addContact(userID, contactID);
    }
}
