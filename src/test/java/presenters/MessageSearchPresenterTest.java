package presenters;

import message_search_use_case.MessageSearchFailed;
import message_search_use_case.MessageSearchResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MessageSearchPresenterTest {
    private MessageSearchPresenter presenter;

    @BeforeEach
    void setUp() {
        this.presenter = new MessageSearchPresenter();
    }

    @Test
    void prepareSuccessView() {
        List<Map<String, String>> listMsg = new ArrayList<>();
        Map<String, String> messageMap1 = new HashMap<>();
        messageMap1.put("sender_name", "John");
        messageMap1.put("message", "Hello! How are you?");

        listMsg.add(messageMap1);
        MessageSearchResponse response = new MessageSearchResponse("Hello!", listMsg, true, null);
        assertEquals(response, presenter.prepareSuccessView(response));
    }

    @Test
    void prepareFailView() {
        String error = "There has been an error!";
        Exception e = assertThrows(MessageSearchFailed.class, () -> presenter.prepareFailView(error));
        assertEquals(error, e.getMessage());
    }
}