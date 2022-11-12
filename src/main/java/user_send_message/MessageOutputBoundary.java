package user_send_message;

import entities.Message;
import entities.TextMessage;

public interface MessageOutputBoundary {
    void sendMessage(TextMessage message);
    void editMessage(TextMessage message);
    void deleteMessage(TextMessage message);
}
