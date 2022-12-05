package entities;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private int id;
    private ArrayList<Message> messages;
    private List<User> users;

    public Chat(int id, List<User> users) {
        this.id = id;
        this.messages = new ArrayList<>();
        this.users = users;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }
    public void removeMessage(Message message) {
        this.messages.remove(message);
    }

    // Getter & Setter Methods

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


}
