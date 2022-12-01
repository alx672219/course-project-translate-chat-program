package message_edit_delete_use_case;

import shared.Response;
/**
 * The response class for the message edit use case.
 */
public class MessageEditResponse extends Response {

    private final String editedText;
    private final int id;

    public MessageEditResponse(String editedText, int id, boolean success, Exception e) {
        this.editedText = editedText;
        this.id = id;
        this.success = success;
        this.e = e;
    }
    public String getEditedText(){
        return this.editedText;
    }
    public int getID(){
        return this.id;
    }

    @Override
    public Exception getException() {
        return super.e;
    }
}
