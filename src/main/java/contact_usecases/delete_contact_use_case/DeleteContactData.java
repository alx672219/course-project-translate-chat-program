package contact_usecases.delete_contact_use_case;

public class DeleteContactData {
    private final int userID;
    private final Long contactID;

    /**
     * Constructor for DeleteContactData.
     *
     * @param userID   the userID being logged in
     * @param contactID the userID that is getting deleted from the userID's contact
     */
    public DeleteContactData(int userID, Long contactID) {
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     * Getter method for userID.
     * @return userID attribute for this DeleteContactData object.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Getter method for contactID.
     * @return contactID attribute for this DeleteContactData object
     */
    public Long getContactID() {
        return contactID;
    }
}
