package entities;

public class Chat {
    private Message[] messages;

    public Chat(Message[] messages) {
        this.messages = messages;
    }

    // Getter & Setter Methods

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
