package contact_usecases.delete_contact_use_case;

public class DeleteContactData {
    private final int userID;
    private final Long contactID;

    public DeleteContactData(int userID, Long contactID) {
        this.userID = userID;
        this.contactID = contactID;
    }

    public int getUserID() {
        return userID;
    }

    public Long getContactID() {
        return contactID;
    }
}
