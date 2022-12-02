package send_message_use_case;

import entities.Message;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import user_send_message.SendMessageResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SendMessageResponseTest {
    private SendMessageResponse response;
    private Message message;

    @BeforeEach
    void setUp() {
        this.message = new Message(456, "Hello! How are you?",
                new User("John", "en", "john@gmail.com", "4567", 10),
                new User("Jacques", "fr", "jacques@gmail.com", "12345",1),
                new Date(126374853));
        this.response = new SendMessageResponse(message, true, null);
    }

    @Test
    void getMessage() {
        assertEquals(message, response.getMessage());
    }

    @Test
    void getException() {
        assertNull(response.getException());
    }
}