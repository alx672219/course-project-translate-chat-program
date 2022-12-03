package gateways;

import entities.User;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import services.DBService;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class CustomizationFirebaseSystemTest {

    private CustomizationFirebaseSystem gateway = new CustomizationFirebaseSystem();
    DBInitializer dbInitializer = new DBInitializer();
    DBService dbService = new DBService();

    @Test
    void existName() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        User user = dbService.getUserDetails(8);
        User newUser = new User("alfred", user.getDefault_lang(), user.getEmail(), user.getPassword());
        assertEquals(true, gateway.existName(newUser));
    }

    @Test
    void notExistName() throws ExecutionException, InterruptedException, FileNotFoundException {
        User user = dbService.getUserDetails(8);
        User newUser = new User("Jonathan", user.getDefault_lang(), user.getEmail(), user.getPassword());
        assertEquals(false, gateway.existName(newUser));
    }
}
