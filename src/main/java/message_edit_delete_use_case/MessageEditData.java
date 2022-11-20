package message_edit_delete_use_case;



public class MessageEditData {
    private final String editText;
    private final int messageID;

    /**
     * Constructor for MessageEditData
     *
     * @param edittext the edited text that the user wants to replace by
     */

    public MessageEditData(String edittext, int messageID){
        this.editText = edittext;
        this.messageID = messageID;
    }
    /**
     * Getter method for edited text.
     * @return edited text attribute for this MessageEditData object.
     */
    public String getEditText(){
        return this.editText;
    }
    public int getID() {return this.messageID;
    }


}
