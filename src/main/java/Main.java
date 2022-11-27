import contact_usecases.add_contact_use_case.AddContactInputBoundary;
import contact_usecases.add_contact_use_case.AddContactInteractor;
import contact_usecases.add_contact_use_case.AddContactOutputBoundary;
import contact_usecases.add_contact_use_case.UserAddContactGateway;
import contact_usecases.delete_contact_use_case.DeleteContactInputBoundary;
import contact_usecases.delete_contact_use_case.DeleteContactInteractor;
import contact_usecases.delete_contact_use_case.DeleteContactOutputBoundary;
import contact_usecases.delete_contact_use_case.UserDeleteContactGateway;
import entities.Message;
import entities.User;
import gateways.*;
import message_edit_delete_use_case.*;
import message_search_use_case.MessageSearchGateway;
import message_search_use_case.MessageSearchInputBoundary;
import message_search_use_case.MessageSearchInteractor;
import message_search_use_case.MessageSearchOutputBoundary;
import org.jetbrains.annotations.NotNull;
import profile_customization_use_case.CustomizationGateway;
import profile_customization_use_case.CustomizationInputBoundary;
import profile_customization_use_case.CustomizationInteractor;
import profile_customization_use_case.CustomizationOutputBoundary;
import services.DBInitializer;
import services.DBService;
import user_login_use_case.LoginInputBoundary;
import user_login_use_case.UserLoginGateway;
import user_login_use_case.UserLoginInteractor;
import user_register_use_case.UserRegistrationGateway;
import user_register_use_case.UserRegistrationInteractor;
import user_send_message.MessageInputBoundary;
import user_send_message.MessageInteractor;
import user_send_message.SendMessageGateway;
import views.*;
import user_register_use_case.UserRegisterInputBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {
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
        DBService dbs = new DBService();

        // Initialize screens
        JPanel registerScreen = initRegisterScreen(nav, dbs);
        JPanel loginSreen = initLoginScreen(nav, dbs);
        JPanel homeScreen = initHomeScreen(nav);
        JPanel chatScreen = initChatScreen(nav, dbs, 3, 3, 4);
        // Add screens to the card layout
        screens.add(registerScreen, "register");
        screens.putClientProperty("register", registerScreen);
        screens.add(loginSreen, "login");
        screens.putClientProperty("login", loginSreen);
        screens.add(homeScreen, "home");
        screens.putClientProperty("home", homeScreen);
        screens.add(chatScreen, "chat");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(640, 640);
        application.setVisible(true);
        nav.showScreen("chat");
    }
    @NotNull
    private static JPanel initHomeScreen(Navigator nav) {
        Map<String, Object> controllers = new HashMap<>();

        CustomizationGateway customizationGateway = new CustomizationGatewayImplementation();
        CustomizationOutputBoundary customizationPresenter = new CustomizationPresenter();
        CustomizationInputBoundary customizationInteractor = new CustomizationInteractor(customizationGateway,
                customizationPresenter);
        CustomizationController customizationController = new CustomizationController(customizationInteractor);

        MessageSearchGateway messageSearchGateway = new MessageSearchFirebaseSystem();
        MessageSearchOutputBoundary messageSearchPresenter = new MessageSearchPresenter();
        MessageSearchInputBoundary messageSearchInteractor = new MessageSearchInteractor(messageSearchGateway,
                messageSearchPresenter);
        MessageSearchController messageSearchController = new MessageSearchController(messageSearchInteractor);

        MessageEditGateway messageEditGateway = new MessageEditFirebaseSystem();
        MessageEditOutputBoundary messageEditPresenter = new MessageEditPresenter();
        MessageEditInputBoundary messageEditInteractor = new MessageEditInteractor(messageEditGateway,
                messageEditPresenter);
        MessageEditController messageEditController = new MessageEditController(messageEditInteractor);

        MessageDeleteGateway messageDeleteGateway = new MessageDeleteFirebaseSystem();
        MessageDeleteOutputBoundary messageDeletePresenter = new MessageDeletePresenter();
        MessageDeleteInputBoundary messageDeleteInteractor = new MessageDeleteInteractor(messageDeleteGateway,
                messageDeletePresenter);
        MessageDeleteController messageDeleteController = new MessageDeleteController(messageDeleteInteractor);

        SendMessageGateway sendMessageGateway = new SendMessageGatewayImplementation();
        MessageInputBoundary sendMessageInteractor = new MessageInteractor(sendMessageGateway);
        SendMessageController sendMessageController = new SendMessageController(sendMessageInteractor);

        UserDeleteContactGateway deleteContactGateway = new UserDeleteContactPersistance();
        DeleteContactOutputBoundary deleteContactPresenter = new DeleteContactPresenter();
        DeleteContactInputBoundary deleteContactInteractor = new DeleteContactInteractor(deleteContactGateway,
                deleteContactPresenter);
        DeleteContactController deleteContactController = new DeleteContactController(deleteContactInteractor);

        UserAddContactGateway addContactGateway = new UserAddContactPersistance();
        AddContactOutputBoundary addContactPresenter = new AddContactPresenter();
        AddContactInputBoundary addContactInteractor = new AddContactInteractor(addContactGateway,
                addContactPresenter);
        AddContactController addContactController = new AddContactController(addContactInteractor);

        controllers.put("customization", customizationController);
        controllers.put("message_search", messageSearchController);
        controllers.put("message_edit", messageEditController);
        controllers.put("message_delete", messageDeleteController);
        controllers.put("send", sendMessageController);
        controllers.put("delete_contact", deleteContactController);
        controllers.put("add_contact", addContactController);

        return new HomeScreen(getLangs(), controllers, nav);
    }

    @NotNull
    private static JPanel initRegisterScreen(Navigator nav, DBService db) {
        UserRegistrationGateway userFactory = new UserRegistrationFirebaseSystem(db);
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserRegisterInputBoundary interactor = new UserRegistrationInteractor(userFactory, presenter);
        UserRegisterController userRegisterController = new UserRegisterController(interactor);

        HashMap<String, String> langs = getLangs();

        return new RegisterScreen(langs, userRegisterController, nav);
    }

    private static HashMap<String, String> getLangs() {
        HashMap<String, String> langs = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/languages.txt"))) {
            String line = br.readLine();

            while (line != null) {
                String[] langCode = line.split(" ");
                langCode[0] = langCode[0].strip();
                langCode[1] = langCode[1].strip();
                langs.put(langCode[0], langCode[1]);
                line = br.readLine();
            }
            return langs;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @NotNull
    private static JPanel initLoginScreen(Navigator nav, DBService db) {
        UserLoginGateway auth = new UserLoginFirebaseSystem(db);
        LoginPresenter presenter = new LoginPresenter();
        LoginInputBoundary interactor = new UserLoginInteractor(auth, presenter);
        LoginController userLoginController = new LoginController(interactor);

        return new LoginScreen(userLoginController, nav);
    }

    @NotNull
    private static JPanel initChatScreen(Navigator nav, DBService db, int chatID,
                                         int senderID, int receiverID) throws ParseException, ExecutionException, InterruptedException {

        MessageEditGateway eGateway = new MessageEditFirebaseSystem();
        MessageEditOutputBoundary ePresenter = new MessageEditPresenter();
        MessageEditInputBoundary eInteractor = new MessageEditInteractor(eGateway, ePresenter);
        MessageEditController eController = new MessageEditController(eInteractor);

        MessageDeleteGateway dGateway = new MessageDeleteFirebaseSystem();
        MessageDeleteOutputBoundary dPresenter = new MessageDeletePresenter();
        MessageDeleteInputBoundary dInteractor = new MessageDeleteInteractor(dGateway, dPresenter);
        MessageDeleteController dController = new MessageDeleteController(dInteractor);

        MessageSearchGateway sGateway = new MessageSearchFirebaseSystem();
        MessageSearchOutputBoundary sPresenter = new MessageSearchPresenter();
        MessageSearchInputBoundary sInteractor = new MessageSearchInteractor(sGateway, sPresenter);
        MessageSearchController sController = new MessageSearchController(sInteractor);

        SendMessageGateway gateway = new SendMessageGatewayImplementation();
        MessageInputBoundary messageInteractor = new MessageInteractor(gateway);
        SendMessageController sendMessageController = new SendMessageController(messageInteractor);

        ArrayList<Message> messages = db.getAllMessages(chatID);

        User sender = db.getUserDetails(senderID);
        String senderName = sender.getName();

        return new ChatScreen(nav, 4, 5, 3, senderName, eController, dController, sController, sendMessageController, messages);
    }
}



