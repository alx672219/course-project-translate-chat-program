package contact_use_case;

import contact_usecases.delete_contact_use_case.DeleteContactResponse;
import entities.Message;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactResponseTest {
    private DeleteContactResponse response;
    private Long contactID;


    @BeforeEach
    void setUp() {
        contactID = 2L;

        this.response = new DeleteContactResponse(1,2L, true, null);
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