package contact_usecases.add_contact_use_case;

import shared.Response;

public class AddContactResponse extends Response {
    private final int userID;

    private final Long contactID;

    public AddContactResponse(int userID, Long contactID, boolean success, Exception e) {
        this.userID = userID;
        this.contactID = contactID;
        this.success = success;
        this.e = e;
    }

    @Override
    public Exception getException() {
        return super.e;
    }

    public Long getContactID() {
        return contactID;
    }

    public int getUserID() {
        return userID;
    }
}
