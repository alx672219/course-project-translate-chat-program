package views;

import contact_usecases.delete_contact_use_case.*;
import controllers.DeleteContactController;
import gateways.UserDeleteContactPersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.DeleteContactPresenter;
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
        initializer.init();
        DeleteContactResponse actualResponse = controller.deleteContact(new DeleteContactData(1, 9L));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(9, actualResponse.getContactID());
    }
}
