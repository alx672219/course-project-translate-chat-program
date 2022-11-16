package tutorial;

import entities.Chat;
import entities.Message;
import entities.User;
import gateways.SendMessageGateway;
import services.DBInitializer;
import services.DBService;
import views.ChatScreen;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
        System.err.println("hi");
        DBInitializer dbInitializer = new DBInitializer();
//        new ChatScreen();
        dbInitializer.init();
        DBService dbService = new DBService();
//
//        User receiver = new User("danny", "en", "danny@gmail.com", " 123");
//        receiver.setUser_id(3);
//        User recipient = new User("bobby", "fr", "bobby@gmail.com", "bob");
//        recipient.setUser_id(4);
//
//        Message message = new Message(4, "hiiiii", receiver, recipient, new Date(2022, Calendar.DECEMBER, 15));
//        System.out.println(dbService.getUserDetails(0).getContacts());
//        dbService.addMessage(message);
//        Chat chat1 = new Chat(2);
//        chat1.addMessage(message);
//        dbService.addChat(chat1);
    }
}
