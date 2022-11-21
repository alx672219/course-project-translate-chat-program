package message_edit_delete_use_case;

public interface MessageEditOutputBoundary {
    MessageEditResponse prepareSuccessView(MessageEditResponse response);

    MessageEditResponse prepareFailureView(String error);
}
