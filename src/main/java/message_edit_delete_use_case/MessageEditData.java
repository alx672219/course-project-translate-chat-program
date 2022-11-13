package message_edit_delete_use_case;

import entities.Message;

public class MessageEditData {
    private final String editText;
    private final Message wantedMessage;

    /**
     * Constructor for MessageEditData
     *
     * @param edittext the edited text that the user wants to replace by
     */

    public MessageEditData(String edittext, Message wantedMessage){
        this.editText = edittext;
        this.wantedMessage = wantedMessage;
    }
    /**
     * Getter method for edited text.
     * @return edited text attribute for this MessageEditData object.
     */
    public String getEditText(){
        return this.editText;
    }
    public Message getOriginalMessage() {return this.wantedMessage;
    }


}
