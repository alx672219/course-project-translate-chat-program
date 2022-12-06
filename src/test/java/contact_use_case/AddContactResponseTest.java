package contact_use_case;

import contact_usecases.add_contact_use_case.AddContactResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class AddContactResponseTest {
    private AddContactResponse response;


    @BeforeEach
    void setUp() {

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