//package views;
//
//import entities.User;
//import services.DBInitializer;
//import services.DBService;
//
//import java.io.FileNotFoundException;
//import java.util.concurrent.ExecutionException;
//
//public class Main1 extends  {
//    Stage window;
//    String address;
//    int port;
//    public static DBService dbService = new DBService();
//
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../views/ChatScreen.fxml"));
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
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
//
//
//
//
