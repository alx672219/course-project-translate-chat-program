package contact_use_case;

import contact_usecases.add_contact_use_case.AddContactResponse;
import entities.Message;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddContactResponseTest {
    private AddContactResponse response;
    private Long contactID;


    @BeforeEach
    void setUp() {
        contactID = 2L;

        this.response = new AddContactResponse(1,2L, true, null);
    }

    @Test
    void getUserID() {
        assertEquals(1, response.getUserID());
    }

    @Test
    void getException() {
        assertNull(response.getException());
    }

    @Test
    void getContactID() {
        assertEquals(2L,response.getContactID());
    }
}