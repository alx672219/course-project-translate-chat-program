package views;

import entities.User;
import gateways.CustomizationFirebaseSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import profile_customization_use_case.*;
import services.DBInitializer;
import services.DBService;

import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class CustomizationControllerTest {

    private CustomizationController controller;
    DBInitializer initializer = new DBInitializer();
    DBService dbService = new DBService();

    @BeforeEach
    void setUp() {
        CustomizationGateway gateway = new CustomizationFirebaseSystem();
        CustomizationOutputBoundary presenter = new CustomizationPresenter();
        CustomizationInputBoundary interactor = new CustomizationInteractor(gateway, presenter);
        this.controller = new CustomizationController(interactor);
    }

    @Test
    void changeLanguageSuccess() throws ExecutionException, InterruptedException, FileNotFoundException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        CustomizationResponse response = controller.changeLanguage(user.getName(), "fr", user.getPassword(), user);
        assertEquals("fr", response.getDefaultLanguage());
    }

    @Test
    void changeLanguageFailBlank() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> {
            controller.changeLanguage(user.getName(), " ", user.getPassword(), user);
        });
        assertEquals("Please enter a language", e.getMessage());
    }

    @Test
    void changeNameSuccess() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        CustomizationResponse response = controller.changeName("Jojo", user.getDefault_lang(), user.getPassword(), user);
        assertEquals("Jojo", response.getName());
    }

    @Test
    void changeNameFailBlank() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> {
            controller.changeName(" ", user.getDefault_lang(), user.getPassword(), user);
        });
        assertEquals("Please enter a name", e.getMessage());
    }

    @Test
    void changeNameFailExist() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> {
            controller.changeName("danny", user.getDefault_lang(), user.getPassword(), user);
        });
        assertEquals("Name already taken, please enter another name", e.getMessage());
    }

    @Test
    void changePasswordSuccess() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        CustomizationResponse response = controller.changePassword(user.getName(), user.getDefault_lang(), "qwertyui", user);
        assertEquals("qwertyui", response.getPassword());
    }

    @Test
    void changePasswordFailBlank() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> {
            controller.changePassword(user.getName(), user.getDefault_lang(), " ", user);
        });
        assertEquals("Please enter a password", e.getMessage());
    }

    @Test
    void changePasswordFailTooShort() throws FileNotFoundException, ExecutionException, InterruptedException {
        initializer.init();
        User user = dbService.getUserDetails(8);
        Exception e = Assertions.assertThrows(CustomizationFailed.class, () -> {
            controller.changePassword(user.getName(), user.getDefault_lang(), "qwe", user);
        });
        assertEquals("Please enter a password longer than 7 characters", e.getMessage());
    }
}
