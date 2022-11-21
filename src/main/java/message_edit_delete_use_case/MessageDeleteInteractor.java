package message_edit_delete_use_case;

import java.util.concurrent.ExecutionException;

public class MessageDeleteInteractor  implements MessageDeleteInputBoundary{
    private final MessageDeleteGateway gateway;
    private final MessageDeleteOutputBoundary presenter;

    public MessageDeleteInteractor(MessageDeleteGateway gateway, MessageDeleteOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }
    @Override
    public MessageDeleteResponse messageDelete(MessageDeleteData data) throws ExecutionException, InterruptedException {
        gateway.delete(data);
        MessageDeleteResponse response = new MessageDeleteResponse(data.getMessageID(), true, null);
        return presenter.prepareSuccessView(response);
    }
}
