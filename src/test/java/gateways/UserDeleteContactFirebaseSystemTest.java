package gateways;

import entities.Message;

import message_search_use_case.MessageSearchData;

import services.DBInitializer;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;


import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class UserDeleteContactFirebaseSystemTest {
    private UserDeleteContactPersistance gateway = new UserDeleteContactPersistance();
    DBInitializer dbInitializer = new DBInitializer();


    @Test
    void addContact() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        gateway.deleteContact(1, 2);
        assert gateway.getUserDetails(1).getContacts().contains(5);
    }
}