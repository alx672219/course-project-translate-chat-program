package views;

import contact_usecases.add_contact_use_case.*;
import controllers.AddContactController;
import gateways.UserAddContactPersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.AddContactPresenter;
import services.DBInitializer;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddContactControllerTest {
    private AddContactController controller;
    DBInitializer initializer = new DBInitializer();

    @BeforeEach
    void setUp() {
        UserAddContactPersistance gateway = new UserAddContactPersistance();
        AddContactOutputBoundary presenter = new AddContactPresenter();
        AddContactInputBoundary interactor = new AddContactInteractor(gateway, presenter);
        this.controller = new AddContactController(interactor);
    }

    @Test
    void addContactYourself() throws FileNotFoundException {
        initializer.init();
        Exception e = assertThrows(AddContactFailed.class, () -> controller.addContact(new AddContactData(1, 1)));
        assertEquals("You can't add yourself as a contact!", e.getMessage());
    }

    @Test
    void addContactDNE() {
        Exception e = assertThrows(AddContactFailed.class, () -> controller.addContact(new AddContactData(1, 999)));
        assertEquals("There is no user with this ID.", e.getMessage());
    }

    @Test
    void addContactAlreadyExist() {
        Exception e = assertThrows(AddContactFailed.class, () -> controller.addContact(new AddContactData(1, 2)));
        assertEquals("You already have a contact with this ID.", e.getMessage());
    }

    @Test
    void addContactSuccess() {
        AddContactResponse actualResponse = controller.addContact(new AddContactData(1, 9));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(9, actualResponse.getContactID());
    }
}
