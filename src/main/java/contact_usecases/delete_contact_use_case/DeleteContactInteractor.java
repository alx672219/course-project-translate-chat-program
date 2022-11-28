package contact_usecases.delete_contact_use_case;

import gateways.UserDeleteContactGateway;
import gateways.UserDeleteContactPersistance;

import java.util.concurrent.ExecutionException;

public class DeleteContactInteractor implements DeleteContactInputBoundary{

    @Override
    public void deleteContact(Long userID, Long contactID) throws ExecutionException, InterruptedException {
        UserDeleteContactGateway userDeleteContactGateway = new UserDeleteContactPersistance();
        userDeleteContactGateway.deleteContact(userID, contactID);
    }
}
