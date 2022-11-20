package message_edit_delete_use_case;
import shared.Response;


public class MessageDeleteResponse extends Response {
    private final int messageID;


    public MessageDeleteResponse(int messageID, boolean success, Exception e) {
        this.messageID = messageID;
        this.success = success;
        this.e = e;
    }

    public int getMessageID() {
        return messageID;
    }

    @Override
    public Exception getException(){
        return super.e;
    }
}
