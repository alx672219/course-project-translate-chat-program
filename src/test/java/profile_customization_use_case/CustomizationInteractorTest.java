package profile_customization_use_case;

import entities.User;
import gateways.CustomizationFirebaseSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.DBInitializer;
import services.DBService;
import presenters.CustomizationPresenter;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;


public class CustomizationInteractorTest {

    private CustomizationInteractor interactor;

    DBInitializer initializer = new DBInitializer();
    DBService dbService = new DBService();

    @BeforeEach
    void setUp() {
        CustomizationGateway gateway = new CustomizationFirebaseSystem();
        CustomizationOutputBoundary presenter = new CustomizationPresenter();
        this.interactor = new CustomizationInteractor(gateway, presenter);}

    @Test
    void changeLanguageSuccess() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(user.getName(), "fr", user.getPassword(), user);
        CustomizationResponse response = interactor.changeLanguage(data);
        Assertions.assertEquals("fr", response.getDefaultLanguage());
    }

    @Test
    void changeLanguageFailBlank() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(user.getName(), " ", user.getPassword(), user);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> interactor.changeLanguage(data));
        Assertions.assertEquals("Please enter a language", e.getMessage());
    }

    @Test
    void changeNameSuccess() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData("name23", user.getDefault_lang(), user.getPassword(), user);
        CustomizationResponse response = interactor.changeName(data);
        Assertions.assertEquals("name23", response.getName());
    }

    @Test
    void changeNameFailBlank() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(" ", user.getDefault_lang(), user.getPassword(), user);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> interactor.changeName(data));
        Assertions.assertEquals("Please enter a name", e.getMessage());
    }

    @Test
    void changeNameFailExist() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData("danny", user.getDefault_lang(), user.getPassword(), user);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> interactor.changeName(data));
        Assertions.assertEquals("Name already taken, please enter another name", e.getMessage());
    }

    @Test
    void changePasswordSuccess() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(user.getName(), user.getDefault_lang(), "qwertyui", user);
        CustomizationResponse response = interactor.changePassword(data);
        Assertions.assertEquals("qwertyui", response.getPassword());
    }

    @Test
    void changePasswordFailBlank() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(user.getName(), user.getDefault_lang(), " ", user);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> interactor.changePassword(data));
        Assertions.assertEquals("Please enter a password", e.getMessage());
    }

    @Test
    void changePasswordFailTooShort() throws ExecutionException, InterruptedException {
        User user = dbService.getUserDetails(8);
        CustomizationData data = new CustomizationData(user.getName(), user.getDefault_lang(), "qwe", user);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> interactor.changePassword(data));
        Assertions.assertEquals("Please enter a password longer than 7 characters", e.getMessage());
    }
}
