package contact_usecases.add_contact_use_case;

public class AddContactData {
    private final int userID;
    private final int contactID;

    public AddContactData(int userID, int contactID) {
        this.userID = userID;
        this.contactID = contactID;
    }

    public int getUserID() {
        return userID;
    }

    public int getContactID() {
        return contactID;
    }
}
