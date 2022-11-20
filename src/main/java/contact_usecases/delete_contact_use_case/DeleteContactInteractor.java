package contact_usecases.delete_contact_use_case;

import java.util.concurrent.ExecutionException;

public class DeleteContactInteractor implements DeleteContactInputBoundary{

    @Override
    public void deleteContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {
        UserDeleteContactGateway userDeleteContactGateway = new UserDeleteContactPersistance();
        userDeleteContactGateway.deleteContact(userID, contactID);
    }
}
