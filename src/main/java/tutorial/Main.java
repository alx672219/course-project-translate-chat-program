package tutorial;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;
import services.DBInitializer;
import services.DBService;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
        System.err.println("hi");
        DBInitializer dbInitializer = new DBInitializer();
        dbInitializer.init();
        DBService dbService = new DBService();
        Chat chat1 = new Chat(3);
        User receiver = new User("danny", "en", "danny@gmail.com", " 123");
        receiver.setUser_id(3);
        dbService.saveUserDetails(receiver);
//        System.out.println(dbService.saveChat(chat1));
//        SendMessageGateway sendMessageGateway = new SendMessageGateway();
//        User recipient = new User("bobby", "fr", "bobby@gmail.com", "bob");
//
//        Message message = new Message(3, "123", receiver, recipient, LocalDate.now());
//        System.err.println(sendMessageGateway.sendMessage(1));
    }
}
