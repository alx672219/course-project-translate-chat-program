package entities;

public class Chat {
    private int id;
    private Message[] messages;

    public Chat(int id) {
        this.id = id;
        this.messages = new Message[]{};
    }

    // Getter & Setter Methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
