package message_edit_delete_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageEditDataTest {
    private MessageEditData data;
    @BeforeEach
    void setUp() {
        this.data = new MessageEditData("bye",3);
    }
    @Test
    void getEditText() {
        assertEquals("bye", data.getEditText());
    }

    @Test
    void getID() {
        assertEquals(3, data.getID());
    }
}