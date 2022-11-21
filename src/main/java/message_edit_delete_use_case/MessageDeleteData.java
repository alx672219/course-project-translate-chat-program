package message_edit_delete_use_case;

public class MessageDeleteData {
    private final int messageID;
    private final int chatID;

    public MessageDeleteData(int messageID, int chatID) {
        this.messageID = messageID;
        this.chatID = chatID;
    }

    public int getMessageID() {
        return messageID;
    }

    public int getChatID() {
        return chatID;
    }
}
