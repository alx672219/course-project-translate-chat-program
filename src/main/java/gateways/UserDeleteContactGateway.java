package gateways;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface UserDeleteContactGateway {
    void deleteContact(Long userID, Long contactID) throws ExecutionException, InterruptedException;


}
