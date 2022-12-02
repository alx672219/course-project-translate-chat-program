package gateways;

import entities.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import services.DBService;
import user_login_use_case.LoginData;
import user_login_use_case.LoginResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests the UserLoginFirebaseSystem using Mockito to mock the
 * database responses.
 */
@RunWith(MockitoJUnitRunner.class)
class UserLoginFirebaseSystemTest {

    static private UserLoginFirebaseSystem loginFirebaseSystem;
    static private final User danny = new User("danny", "en", "danny@gmail.com", "123",
            17);
    static private LoginData goodData;
    static private LoginData badData1;
    static private LoginData badData2;

    /**
     * Sets up the mock database before any of the tests run.
     * @throws ExecutionException in case the database cannot be accessed
     * @throws InterruptedException in case the database cannot be accessed
     */
    @BeforeAll
    public static void setup() throws ExecutionException, InterruptedException {
        DBService db = mock(DBService.class);
        loginFirebaseSystem = new UserLoginFirebaseSystem(db);
        goodData = new LoginData("danny", "123");
        badData1 = new LoginData("danny", "356");
        badData2 = new LoginData("Doesn't exist", "password");
        when(db.getByUsername("danny")).thenReturn(danny);
        when(db.getByUsername("Doesn't exist")).thenReturn(null);
    }

    /**
     * Tests a successful login.
     * @throws IOException in case the database cannot be accessed.
     */
    @Test
    void loginGood() throws IOException {
        LoginResponse resp = loginFirebaseSystem.login(goodData);
        assertTrue(resp.isSuccess());
    }

    /**
     * Tests a login with an incorrect password.
     * @throws IOException in case the database cannot be accessed.
     */
    @Test
    void loginBadPassword() throws IOException {
        LoginResponse resp = loginFirebaseSystem.login(badData1);
        assertFalse(resp.isSuccess());
        assertEquals(resp.getException().getMessage(), "Password doesn't match");
    }

    /**
     * Tests a login where the username does not exist.
     * @throws IOException in case the database cannot be accessed.
     */
    @Test
    void loginBadUsername() throws IOException {
        LoginResponse resp = loginFirebaseSystem.login(badData2);
        assertFalse(resp.isSuccess());
        assertEquals(resp.getException().getMessage(), "User not found");
    }

}