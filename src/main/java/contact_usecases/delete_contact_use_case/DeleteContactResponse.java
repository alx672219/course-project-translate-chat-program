package contact_usecases.delete_contact_use_case;

import shared.Response;

public class DeleteContactResponse extends Response {
    private final int userID;

    private final Long contactID;

    public DeleteContactResponse(int userID, Long contactID, boolean success, Exception e) {
        this.userID = userID;
        this.contactID = contactID;
        this.success = success;
        this.e = e;
    }

    public int getUserID() {
        return userID;
    }

    public Long getContactID() {
        return contactID;
    }

    @Override
    public Exception getException() {
        return super.e;
    }
}
