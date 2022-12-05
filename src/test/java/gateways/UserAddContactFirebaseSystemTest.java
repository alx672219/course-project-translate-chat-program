package gateways;

import services.DBInitializer;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import java.util.concurrent.ExecutionException;


public class UserAddContactFirebaseSystemTest {
    private final UserAddContactPersistance gateway = new UserAddContactPersistance();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void addContact() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        gateway.addContact(1, 5);
        assert gateway.getUserDetails(1).getContacts().contains(5L);
    }
}