package gateways;

import entities.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import services.DBService;
import user_register_use_case.CreationData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests UserRegistrationFirebaseSystem using Mockito to mock the database
 * response.
 */
@RunWith(MockitoJUnitRunner.class)
class UserRegistrationFirebaseSystemTest {

    static private UserRegistrationFirebaseSystem registerFirebaseSystem;
    static private final User danny = new User("danny", "en", "danny@gmail.com", " 123", 1);
    static private final User alfred = new User("alfred", "en", "alfred@gmail.com", "alfred", 2);
    static private CreationData goodData;
    static private CreationData badData;

    /**
     * Sets up the mock database response before any tests run.
     * @throws ExecutionException in case the database cannot be accessed
     * @throws InterruptedException in case the database cannot be accessed
     */
    @BeforeAll
    public static void setup() throws ExecutionException, InterruptedException {
        DBService db = mock(DBService.class);
        registerFirebaseSystem = new UserRegistrationFirebaseSystem(db);
        badData = new CreationData("danny", "en", "danny@gmail.com", "122");
        goodData = new CreationData("alfred", "en", "alfred@gmail.com", "alfred");
        when(db.getByUsername("danny")).thenReturn(danny);
        when(db.getByUsername("alfred")).thenReturn(null);
        when(db.saveUserDetails(alfred)).thenReturn("time");
        when(db.getAllUserId()).thenReturn(new ArrayList<>(Arrays.asList(1, 2, 3)));
    }

    /**
     * Tests a successful registration
     */
    @Test
    void createGood() {
        assertTrue(registerFirebaseSystem.create(goodData));
    }

    /**
     * Tests a registration where the username is already in use
     */
    @Test
    void createSameUsername() {
        assertFalse(registerFirebaseSystem.create(badData));
    }

}