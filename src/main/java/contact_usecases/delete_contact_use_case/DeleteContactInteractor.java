package contact_usecases.delete_contact_use_case;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DeleteContactInteractor implements DeleteContactInputBoundary{

    final UserDeleteContactGateway gateway;
    final DeleteContactOutputBoundary presenter;

    public DeleteContactInteractor(UserDeleteContactGateway gateway, DeleteContactOutputBoundary presenter) {
        this.gateway = gateway;
        this.presenter = presenter;
    }

    @Override
    public DeleteContactResponse deleteContact(DeleteContactData data) {
        List<Integer> ids = gateway.deleteContact(data.getUserID(), data.getContactID().intValue());
        DeleteContactResponse response = new DeleteContactResponse(ids.get(0), Long.valueOf(ids.get(1)), true, null);
        return presenter.prepareSuccessView(response);
    }
}
