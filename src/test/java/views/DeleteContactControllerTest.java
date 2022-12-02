package views;

import contact_usecases.add_contact_use_case.AddContactData;
import contact_usecases.add_contact_use_case.AddContactResponse;
import contact_usecases.delete_contact_use_case.*;
import gateways.MessageSearchFirebaseSystem;
import gateways.UserDeleteContactFirebaseSystemTest;
import gateways.UserDeleteContactPersistance;
import message_search_use_case.MessageSearchGateway;
import message_search_use_case.MessageSearchInputBoundary;
import message_search_use_case.MessageSearchInteractor;
import message_search_use_case.MessageSearchOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteContactControllerTest {
    private DeleteContactController controller;
    DBInitializer initializer = new DBInitializer();

    @BeforeEach
    void setUp() {
        UserDeleteContactPersistance gateway = new UserDeleteContactPersistance();
        DeleteContactOutputBoundary presenter = new DeleteContactPresenter();
        DeleteContactInputBoundary interactor = new DeleteContactInteractor(gateway, presenter);
        this.controller = new DeleteContactController(interactor);
    }

    @Test
    void deleteContactSuccess() throws FileNotFoundException {
        DeleteContactResponse actualResponse = controller.deleteContact(new DeleteContactData(1, 9));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(9, actualResponse.getContactID());
    }
}
