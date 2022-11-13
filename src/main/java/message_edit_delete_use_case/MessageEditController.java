package message_edit_delete_use_case;

public class MessageEditController {
    private final MessageEditInputBoundary messageEditInputBoundary;
    public MessageEditController(MessageEditInputBoundary messageEditInputBoundary){
        this.messageEditInputBoundary = messageEditInputBoundary;

    }
    public void editMessage(){
        messageEditInputBoundary.editMessage();
    }
}
