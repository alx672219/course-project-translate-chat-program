package message_edit_delete_use_case;

public interface MessageEditInputBoundary {
    MessageEditResponse editMessage(MessageEditData data);
}
