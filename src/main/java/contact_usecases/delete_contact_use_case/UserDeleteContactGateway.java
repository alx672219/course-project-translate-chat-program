package contact_usecases.delete_contact_use_case;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface UserDeleteContactGateway {
    void deleteContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException;


}
