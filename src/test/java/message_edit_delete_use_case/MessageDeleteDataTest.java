package message_edit_delete_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageDeleteDataTest {
    private MessageDeleteData data;
    @BeforeEach
    void setUp() {
        this.data = new MessageDeleteData(3,3);
    }

    @Test
    void getMessageID() {
        assertEquals(data.getMessageID(), 3);
    }

    @Test
    void getChatID() {
        assertEquals(data.getChatID(), 3);
    }
}