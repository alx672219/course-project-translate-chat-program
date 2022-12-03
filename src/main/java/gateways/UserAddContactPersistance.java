package gateways;

import contact_usecases.add_contact_use_case.UserAddContactGateway;
import entities.Chat;
import entities.User;
import services.DBService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserAddContactPersistance implements UserAddContactGateway {
    DBService dbService;

    public UserAddContactPersistance() {
        this.dbService = DBService.getInstance();
    }

    @Override
    public void addContact(Integer userID, Integer contactID) throws ExecutionException, InterruptedException {

        User mainUser = dbService.getUserDetails(userID);
        User contactUser = dbService.getUserDetails(contactID);

        dbService.addContact(mainUser, Long.valueOf(contactID));
        dbService.addContact(contactUser, Long.valueOf(userID));


        List<Integer> chatIDs = dbService.getAllIDs("chats");
        int nextChatID = Collections.max(chatIDs) + 1;
        List<User> users = new ArrayList<>();
        users.add(mainUser);
        users.add(contactUser);
        Chat chatToAdd = new Chat(nextChatID, users);
        dbService.addChat(chatToAdd);
    }

    @Override
    public User getUserDetails(int userID) {
        try {
            return dbService.getUserDetails(userID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
