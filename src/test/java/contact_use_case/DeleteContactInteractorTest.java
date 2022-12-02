package contact_use_case;


import contact_usecases.delete_contact_use_case.*;
import gateways.UserDeleteContactPersistance;
import message_search_use_case.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import views.AddContactPresenter;
import views.DeleteContactPresenter;
import views.MessageSearchPresenter;

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
    void searchSuccess() throws ExecutionException, InterruptedException {
        DeleteContactResponse actualResponse = interactor.deleteContact(new DeleteContactData(1,2L));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(null, actualResponse.getContactID());
    }
}
