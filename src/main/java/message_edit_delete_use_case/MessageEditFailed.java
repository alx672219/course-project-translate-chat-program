package message_edit_delete_use_case;

public class MessageEditFailed extends RuntimeException{
    public MessageEditFailed(String error){
        super(error);
    }
}
