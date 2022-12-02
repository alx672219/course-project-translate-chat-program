package views;

import contact_usecases.add_contact_use_case.AddContactResponse;
import contact_usecases.delete_contact_use_case.DeleteContactResponse;
import entities.Message;
import entities.User;
import message_search_use_case.MessageSearchData;
import message_search_use_case.MessageSearchFailed;
import message_search_use_case.MessageSearchResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteContactPresenterTest {
    private DeleteContactPresenter presenter;

    @BeforeEach
    void setUp() {
        this.presenter = new DeleteContactPresenter();
    }

    @Test
    void prepareSuccessView() {
        DeleteContactResponse response = new DeleteContactResponse(1, 9L, true, null);
        assertEquals(response, presenter.prepareSuccessView(response));
    }

    @Test
    void prepareFailView() {
        String error = "There has been an error!";
        Exception e = assertThrows(MessageSearchFailed.class, () -> {
            presenter.prepareFailView(error);
        });
        assertEquals(error, e.getMessage());
    }
}