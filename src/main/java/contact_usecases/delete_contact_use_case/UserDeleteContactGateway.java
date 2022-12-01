package contact_usecases.delete_contact_use_case;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserDeleteContactGateway {
    List<Integer> deleteContact(Integer userID, Integer contactID);


}
