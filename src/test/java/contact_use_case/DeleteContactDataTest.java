package contact_use_case;

import contact_usecases.delete_contact_use_case.DeleteContactData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactDataTest {
    private DeleteContactData data;

    @BeforeEach
    void setUp() {
        this.data = new DeleteContactData(1, 2L);
    }

    @Test
    void getTUserID() {
        assertEquals(data.getUserID(), 1);
    }

    @Test
    void getContactID() {
        assertEquals(data.getContactID(), 2L);
    }
}