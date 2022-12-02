package contact_use_case;


import contact_usecases.add_contact_use_case.*;
import gateways.UserAddContactPersistance;
import message_search_use_case.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DBInitializer;
import views.AddContactPresenter;
import views.MessageSearchPresenter;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
public class AddContactInteractorTest {

    private AddContactInteractor interactor;
    DBInitializer initializer = new DBInitializer();

    @BeforeEach
    void setUp() {
        UserAddContactGateway gateway = new UserAddContactPersistance();
        AddContactOutputBoundary presenter = new AddContactPresenter();
        this.interactor = new AddContactInteractor(gateway, presenter);
    }



    @Test
    void searchSuccess() throws ExecutionException, InterruptedException {
        AddContactResponse actualResponse = interactor.addContact(new AddContactData(1,2));
        assertEquals(1, actualResponse.getUserID());
        assertEquals(2, actualResponse.getContactID());
    }
}
