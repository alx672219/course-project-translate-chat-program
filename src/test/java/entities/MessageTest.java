package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    private Message message;

    private User receiver;

    private User recipient;

    private Date timestamp;

    @BeforeEach
    void setUp() {
        this.receiver = new User("Danny", "en", "test@gmail.com", "123");
        this.recipient = new User("Alex", "fr", "test@gmail.com", "123");
        this.timestamp = new Date();
        this.message = new Message(1, "Test", receiver, recipient, timestamp);
    }

    @Test
    void getID() {
        int expected = message.getId();
        assertEquals(1, expected);
    }

    @Test
    void getMessage() {
        String expected = message.getMessage();
        assertEquals("Test", expected);
    }

    @Test
    void getReceiver() {
        User expected = message.getReceiver();
        assertEquals(receiver, expected);
    }

    @Test
    void getRecipient() {
        User expected = message.getRecipient();
        assertEquals(recipient, expected);
    }

    @Test
    void getDate() {
        Date expected = timestamp;
        assertEquals(expected, message.getTimestamp());
    }

    @Test
    void setID() {
        assertEquals(message.getId(), 1);
        message.setId(2);
        assertEquals(message.getId(), 2);
    }

    @Test
    void setMessage() {
        assertEquals(message.getMessage(), "Test");
        message.setMessage("updated");
        assertEquals(message.getMessage(), "updated");
    }

    @Test
    void setReceiver() {
        assertEquals(message.getReceiver(), receiver);
        User newReceiver = new User("Danny", "en", "dan@gmail.com", "123");
        message.setReceiver(newReceiver);
        assertEquals(message.getReceiver(), newReceiver);
    }

    @Test
    void setRecipient() {
        assertEquals(message.getRecipient(), recipient);
        User newRecipient = new User("Danny", "en", "dan@gmail.com", "123");
        message.setRecipient(newRecipient);
        assertEquals(message.getRecipient(), newRecipient);
    }

    @Test
    void setTimestamp() {
        assertEquals(message.getTimestamp(), timestamp);
        Date newDate = new Date();
        message.setTimestamp(newDate);
        assertEquals(message.getTimestamp(), newDate);
    }
}