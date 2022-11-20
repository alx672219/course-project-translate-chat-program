package message_edit_delete_use_case;

import entities.Message;
import message_search_use_case.MessageSearchOutputBoundary;

public class MessageEditInteractor implements MessageEditInputBoundary {
    private final MessageEditGateway gateway;
    private final MessageEditOutputBoundary presenter;




    public MessageEditInteractor(MessageEditGateway gateway, MessageEditOutputBoundary presenter){
        this.gateway = gateway;
        this.presenter = presenter;
        }
    @Override
    public MessageEditResponse editMessage(MessageEditData data){
        if (data.getEditText().isEmpty()){
            return presenter.prepareFailureView("Can't edit with empty text");
        }
        gateway.edit(data);
        MessageEditResponse response = new MessageEditResponse(data.getEditText(), data.getID(), true, null);
        return presenter.prepareSuccessView(response);

    }
}