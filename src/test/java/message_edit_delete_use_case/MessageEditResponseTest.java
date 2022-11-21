package message_edit_delete_use_case;

import entities.Message;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageEditResponseTest {
    private MessageEditResponse response;
    private List<Message> listMsg;


    @BeforeEach
    void setUp() {
        listMsg = new ArrayList<>();
        listMsg.add(new Message(456, "Hello! How are you?",
                new User("John", "en", "john@gmail.com", "4567", 10),
                new User("Jacques", "fr", "jacques@gmail.com", "12345",1),
                new Date(126374853)));
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