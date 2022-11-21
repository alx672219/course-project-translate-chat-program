import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import entities.User;
import gateways.CustomizationGatewayImplementation;
import profile_customization_use_case.CustomizationGateway;
import profile_customization_use_case.CustomizationInteractor;
import services.DBInitializer;
import services.DBService;
import views.CustomizationController;
import views.CustomizationPresenter;
import views.ProfileScreen;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

public class Main extends JFrame{
    public static void main(String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
        JFrame application = new JFrame("Application");
        DBInitializer dbInitializer = new DBInitializer();
        dbInitializer.init();
        DBService dbService = new DBService();
        User user = dbService.getUserDetails(5);

        CustomizationPresenter presenter = new CustomizationPresenter();
        CustomizationGateway gateway = new CustomizationGatewayImplementation();
        CustomizationInteractor interactor = new CustomizationInteractor(gateway, presenter);
        CustomizationController controller = new CustomizationController(interactor);
        JPanel ProfileScreen = new ProfileScreen(controller, user);

        application.add(ProfileScreen);
        application.pack(); // Sets size according to components
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setVisible(true);
    }
}
