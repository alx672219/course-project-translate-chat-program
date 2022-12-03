package contact_use_case;

import contact_usecases.add_contact_use_case.AddContactData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddContactDataTest {
    private AddContactData data;

    @BeforeEach
    void setUp() {
        this.data = new AddContactData(1, 2);
    }

    @Test
    void getTUserID() {
        assertEquals(data.getUserID(), 1);
    }

    @Test
    void getContactID() {
        assertEquals(data.getContactID(), 2);
    }
}