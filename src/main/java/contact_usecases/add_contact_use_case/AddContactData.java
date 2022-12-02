package contact_usecases.add_contact_use_case;

public class AddContactData {
    private final int userID;
    private final int contactID;


    /**
     * Constructor for AddContactData.
     *
     * @param userID   the userID being logged in
     * @param contactID the userID that is getting added into the userID's contact
     */
    public AddContactData(int userID, int contactID) {
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     * Getter method for userID.
     * @return userID attribute for this AddContactData object.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Getter method for contactID.
     * @return contactID attribute for this AddContactData object
     */
    public int getContactID() {
        return contactID;
    }
}
