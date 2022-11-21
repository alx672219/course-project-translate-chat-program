package message_edit_delete_use_case;

import java.util.concurrent.ExecutionException;

public interface MessageDeleteGateway {
    void delete(MessageDeleteData data) throws ExecutionException, InterruptedException;
}
