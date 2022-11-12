package user_send_message;

import entities.TextMessage;

public class MessageInteractor implements MessageOutputBoundary {
    public void sendMessage(TextMessage message) {};

    public void editMessage(TextMessage message) {};

    public void deleteMessage(TextMessage message) {};

}
