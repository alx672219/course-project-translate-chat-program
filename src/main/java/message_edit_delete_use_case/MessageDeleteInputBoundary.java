package message_edit_delete_use_case;

import java.util.concurrent.ExecutionException;

public interface MessageDeleteInputBoundary {
    MessageDeleteResponse messageDelete(MessageDeleteData data) throws ExecutionException, InterruptedException;
}
