package contact_usecases.delete_contact_use_case;

import shared.Response;

public class DeleteContactResponse extends Response {
    private final int userID;

    private final Long contactID;

    /**
     * Constructor for DeleteContactResponse.
     * @param userID userID that is being logged in
     * @param contactID userID that is getting deleted from the userID's contact
     * @param success whether deleting contact was successful
     * @param e exception that was thrown if success is false, null otherwise
     */
    public DeleteContactResponse(int userID, Long contactID, boolean success, Exception e) {
        this.userID = userID;
        this.contactID = contactID;
        this.success = success;
        this.e = e;
    }

    /**
     * Getter method for userID.
     * @return the userID attribute of this DeleteContactResponse object
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Getter method for contactID.
     * @return the contactID attribute of this DeleteContactResponse object
     */
    public Long getContactID() {
        return contactID;
    }

    /**
     * Getter method for e.
     * @return the e (exception) attribute for this DeleteContactResponse object
     */
    @Override
    public Exception getException() {
        return super.e;
    }
}
