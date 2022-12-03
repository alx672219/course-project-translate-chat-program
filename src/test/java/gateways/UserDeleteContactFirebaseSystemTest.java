package gateways;



import services.DBInitializer;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class UserDeleteContactFirebaseSystemTest {
    private final UserDeleteContactPersistance gateway = new UserDeleteContactPersistance();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void addContact() throws FileNotFoundException {
        dbInitializer.init();
        gateway.deleteContact(1, 2);
        assert gateway.getUserDetails(1).getContacts().contains(5L);
    }
}