package contact_use_case;


import contact_usecases.delete_contact_use_case.*;
import gateways.UserDeleteContactPersistance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import presenters.DeleteContactPresenter;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
public class DeleteContactInteractorTest {

    private DeleteContactInteractor interactor;
    DBInitializer initializer = new DBInitializer();

    @BeforeEach
    void setUp() {
        UserDeleteContactGateway gateway = new UserDeleteContactPersistance();
        DeleteContactOutputBoundary presenter = new DeleteContactPresenter();
        this.interactor = new DeleteContactInteractor(gateway, presenter);
    }



    @Test
    void searchSuccess() throws FileNotFoundException {
        initializer.init();
        DeleteContactResponse actualResponse = interactor.deleteContact(new DeleteContactData(1,2L));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(2, actualResponse.getContactID());
    }
}
