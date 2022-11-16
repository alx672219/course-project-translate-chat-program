import gateways.UserLoginFirebaseSystem;
import gateways.UserRegistrationFirebaseSystem;
import org.jetbrains.annotations.NotNull;
import services.DBInitializer;
import user_login_use_case.LoginInputBoundary;
import user_login_use_case.UserLoginGateway;
import user_login_use_case.UserLoginInteractor;
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

        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        JFrame application = new JFrame("Translation App");
        application.add(screens);

        Navigator nav = new CardLayoutNavigator(cardLayout, screens);

        // Initialize screens
        JPanel registerScreen = initRegisterScreen(nav);
        JPanel loginSreen = initLoginScreen(nav);
        // Add screens to the card layout
        screens.add(registerScreen, "register");
        screens.add(loginSreen, "login");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(640, 640);
        application.setVisible(true);
        nav.showScreen("register");
    }
    @NotNull
    private static JPanel initRegisterScreen(Navigator nav) {
        UserRegistrationGateway userFactory = new UserRegistrationFirebaseSystem();
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserRegisterInputBoundary interactor = new UserRegistrationInteractor(userFactory, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        String[] langs = {"english", "arabic", "chinese", "korean", "polish"};
        return new RegisterScreen(langs, userRegisterController, nav);
    }
    @NotNull
    private static JPanel initLoginScreen(Navigator nav) {
        UserLoginGateway auth = new UserLoginFirebaseSystem();
        LoginPresenter presenter = new LoginPresenter();
        LoginInputBoundary interactor = new UserLoginInteractor(auth, presenter);
        LoginController userLoginController = new LoginController(interactor);

        return new LoginScreen(userLoginController, nav);
    }

}
