package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        this.user = new User("Name", "English", "email.com", "123p", 123);
    }

    @Test
    void getName() {
        String expected = user.getName();
        assertEquals("Name", expected);
    }

    @Test
    void getPassword() {
        String expected = user.getPassword();
        assertEquals(expected, "123p");
    }

    @Test
    void getEmail() {
        String expected = user.getEmail();
        assertEquals(expected, "email.com");
    }

    @Test
    void getDefaultLang() {
        String expected = user.getDefaultLang();
        assertEquals(expected, "English");
    }

    @Test
    void setName() {
        assertEquals(user.getName(), "Name");
        user.setName("new name");
        assertEquals(user.getName(), "new name");
    }

    @Test
    void setEmail() {
        assertEquals(user.getEmail(), "email.com");
        user.setEmail("new email");
        assertEquals(user.getEmail(), "new email");
    }

    @Test
    void setPassword() {
        assertEquals(user.getPassword(), "123p");
        user.setPassword("123q");
        assertEquals(user.getPassword(), "123q");
    }

    @Test
    void setDefaultLang() {
        assertEquals(user.getDefaultLang(), "English");
        user.setDefaultLang("Arabic");
        assertEquals(user.getDefaultLang(), "Arabic");
    }

}