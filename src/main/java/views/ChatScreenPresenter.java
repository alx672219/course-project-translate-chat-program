//package views;
//
//import entities.Message;
//import entities.User;
//import gateways.SendMessageGateway;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import user_send_message.MessageInputBoundary;
//
//import java.time.LocalDate;
//import java.util.concurrent.ExecutionException;
//
//public class ChatScreenPresenter {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        SendMessageGateway sendMessageGateway = new SendMessageGateway();
//        User receiver = new User("danny", "en", "danny@gmail.com", " 123");
//        User recipient = new User("bobby", "fr", "bobby@gmail.com", "bob");
//
//        Message message = new Message(3, "123", receiver, recipient, LocalDate.now());
//        sendMessageGateway.sendMessage(1, message);
//    }
//
//}