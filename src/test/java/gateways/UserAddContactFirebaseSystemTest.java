package gateways;

import entities.Message;

import message_search_use_case.MessageSearchData;

import services.DBInitializer;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class UserAddContactFirebaseSystemTest {
    private UserAddContactPersistance gateway = new UserAddContactPersistance();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void addContact() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        gateway.addContact(1, 5);
        assert gateway.getUserDetails(1).getContacts().contains(5);
    }
}