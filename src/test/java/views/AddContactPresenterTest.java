package views;

import contact_usecases.add_contact_use_case.AddContactResponse;
import message_search_use_case.MessageSearchFailed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.AddContactPresenter;

import static org.junit.jupiter.api.Assertions.*;

class AddContactPresenterTest {
    private AddContactPresenter presenter;

    @BeforeEach
    void setUp() {
        this.presenter = new AddContactPresenter();
    }

    @Test
    void prepareSuccessView() {
        AddContactResponse response = new AddContactResponse(1, 9L, true, null);
        assertEquals(response, presenter.prepareSuccessView(response));
    }

    @Test
    void prepareFailView() {
        String error = "There has been an error!";
        Exception e = assertThrows(MessageSearchFailed.class, () -> presenter.prepareFailView(error));
        assertEquals(error, e.getMessage());
    }
}