package message_edit_delete_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MessageDeleteResponseTest {

    private MessageDeleteResponse response;


    @BeforeEach
    void setUp() {
        this.response = new MessageDeleteResponse(3, true, null);
    }
    @Test
    void getMessageID(){
        assertEquals(3, response.getMessageID());
    }


    @Test
    void getException() {
        assertNull(response.getException());
    }
}