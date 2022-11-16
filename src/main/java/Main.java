import gateways.UserRegistrationFirebaseSystem;
import org.jetbrains.annotations.NotNull;
import services.DBInitializer;
import user_register_use_case.UserRegistrationGateway;
import user_register_use_case.UserRegistrationInteractor;
import views.*;
import user_register_use_case.UserRegisterInputBoundary;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Set up Database
        try {
            new DBInitializer().init();
        } catch (Exception ignored) {
        }

        // Build the main program window
        JFrame registerScreen = initRegisterScreen();
        registerScreen.setVisible(true);

    }

    @NotNull
    private static JFrame initRegisterScreen() {
        JFrame application = new JFrame("Register Screen");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        UserRegistrationGateway userFactory = new UserRegistrationFirebaseSystem();
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserRegisterInputBoundary interactor = new UserRegistrationInteractor(userFactory, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        String[] langs = {"english", "arabic", "chinese", "korean", "polish"};
        RegisterScreen registerScreen = new RegisterScreen(langs, userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.setSize(640, 640);
        return application;
    }

}
