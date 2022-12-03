package message_edit_delete_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MessageEditResponseTest {
    private MessageEditResponse response;


    @BeforeEach
    void setUp() {
        this.response = new MessageEditResponse("bye", 3, true, null);
    }

    @Test
    void getException() {
        assertNull(response.getException());
    }


    @Test
    void getEditedText() {
    assertEquals("bye", response.getEditedText());

    }
    @Test
    void getID() {
        assertEquals(3, response.getID());
    }


}