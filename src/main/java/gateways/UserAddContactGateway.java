package gateways;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public interface UserAddContactGateway {
    void addContact(Long userID, Long contactID) throws ExecutionException, InterruptedException;


}
