package gateways;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.DBInitializer;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

public class CustomizationFirebaseSystemTest {

    private final CustomizationFirebaseSystem gateway = new CustomizationFirebaseSystem();
    DBInitializer dbInitializer = new DBInitializer();

    @Test
    void getByUsername() throws ExecutionException, InterruptedException, FileNotFoundException {
        dbInitializer.init();
        Assertions.assertNotEquals(null, gateway.getByUsername("alfred"));
    }

    @Test
    void notExistName() throws ExecutionException, InterruptedException {
        Assertions.assertNull(gateway.getByUsername("Jonathan"));
    }
}
