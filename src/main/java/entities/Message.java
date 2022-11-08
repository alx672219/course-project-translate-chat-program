package entities;

import java.util.Date;

public class Message {
    private int id;

    private String message;

    private User receiver;

    private User recipient;

    private Date timestamp;

    public Message(String message, User receiver, User recipient, Date timestamp) {
        this.message = message;
        this.receiver = receiver;
        this.recipient = recipient;
        this.timestamp = timestamp;
    }

    // Getter & Setter Methods
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
