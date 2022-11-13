//package tutorial;
//
//import entities.User;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.RowConstraints;
//import javafx.stage.Stage;
//import services.DBInitializer;
//import services.DBService;
//
//import java.io.FileNotFoundException;
//import java.util.concurrent.ExecutionException;
//
//public class Main extends Application {
//    Stage window;
//    String address;
//    int port;
//    public static DBService dbService = new DBService();
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        address = super.getParameters().getRaw().get(0);
//        port = Integer.parseInt(super.getParameters().getRaw().get(1));
//
//        // Window
//        this.window = primaryStage;
//        this.window.setTitle("Client");
//
//        // Grid
//        GridPane grid = new GridPane();
//        grid.setVgap(8);
//        grid.setHgap(10);
//        grid.setPadding(new Insets(10, 10, 10, 10));
//
//        // Set up columns
//        ColumnConstraints column0 = new ColumnConstraints();
//        column0.setPercentWidth(75);
//
//        ColumnConstraints column1 = new ColumnConstraints();
//        column1.setPercentWidth(20);
//
//        // Set up rows
//        RowConstraints row0 = new RowConstraints();
//        row0.setPercentHeight(75);
//
//        RowConstraints row1 = new RowConstraints();
//        row1.setPercentHeight(20);
//
//        RowConstraints row2 = new RowConstraints();
//        row1.setPercentHeight(20);
//
//        // Add columns and rows to the grid
//        grid.getRowConstraints().addAll(row0, row1, row2);
//        grid.getColumnConstraints().addAll(column0, column1);
//
//        // Scene
//        Scene scene = new Scene(600, 520);
//        scene.getStylesheets().add("css/main.css");
//
//        // Finish window
//        this.window.setScene(scene);
//        this.window.show();
//
//    }
//
//    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {
//        DBInitializer dbInitializer = new DBInitializer();
//        dbInitializer.init();
//
//        launch(args);
////        System.out.println("s");
////        System.out.println(Main.getUser(1));
//
//    }
//
//    public static User getUser(int userID) throws ExecutionException, InterruptedException {
//        try {
//            return dbService.getUserDetails(userID);
//        } catch (Exception e) {
//            System.err.println("error");
//        }
//        return null;
//    }
//
//    public static String addUser(User user) throws ExecutionException, InterruptedException {
//        try {
//            return dbService.saveUserDetails(user);
//        } catch (Exception e) {
//            System.err.println("error");
//        }
//        return null;
//    }
//}
