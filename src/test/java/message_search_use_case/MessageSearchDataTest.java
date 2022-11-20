package message_search_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageSearchDataTest {
    private MessageSearchData data;

    @BeforeEach
    void setUp() {
        this.data = new MessageSearchData("hello", 1);
    }

    @Test
    void getText() {
        assert(data.getText().equals("hello"));
    }

    @Test
    void getChatId() {
        assertEquals(data.getChatId(), 1);
    }
}