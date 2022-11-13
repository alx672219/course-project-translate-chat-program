package message_edit_delete_use_case;

import entities.Message;

public class MessageEditUseCase implements MessageEditInputBoundary {
    private final MessageEditData data;

    public MessageEditUseCase(MessageEditData data){
    this.data = data;}
    @Override
    public void editMessage(){
        Message message = this.data.getOriginalMessage();
        String wanted = this.data.getEditText();
        message.setMessage(wanted);
    }
}