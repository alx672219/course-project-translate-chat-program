package message_search_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageSearchResponseTest {
    private MessageSearchResponse response;
    private List<Map<String, String>> listMsg;


    @BeforeEach
    void setUp() {
        listMsg = new ArrayList<>();
        Map<String, String> messageMap1 = new HashMap<>();
        messageMap1.put("sender_name", "John");
        messageMap1.put("message", "Hello! How are you?");

        listMsg.add(messageMap1);
        this.response = new MessageSearchResponse("Hello", listMsg, true, null);
    }

    @Test
    void getText() {
        assertEquals("Hello", response.getText());
    }

    @Test
    void getException() {
        assertNull(response.getException());
    }

    @Test
    void getMessages() {
        assertEquals(listMsg, response.getMessages());
    }
}