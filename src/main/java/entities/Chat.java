package entities;

import java.util.ArrayList;

public class Chat {
    private int id;
    private ArrayList<Message> messages;

    public Chat(int id) {
        this.id = id;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        this.messages.add(message);
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
}
