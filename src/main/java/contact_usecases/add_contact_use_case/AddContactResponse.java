package contact_usecases.add_contact_use_case;

import shared.Response;

public class AddContactResponse extends Response {
    private final int userID;

    private final Long contactID;

    /**
     * Constructor for AddContactResponse.
     * @param userID userID that is being logged in
     * @param contactID userID that is getting added to the userID's contact
     * @param success whether adding contact was successful
     * @param e exception that was thrown if success is false, null otherwise
     */
    public AddContactResponse(int userID, Long contactID, boolean success, Exception e) {
        this.userID = userID;
        this.contactID = contactID;
        this.success = success;
        this.e = e;
    }

    /**
     * Getter method for e.
     * @return the e (exception) attribute for this AddContactResponse object
     */
    @Override
    public Exception getException() {
        return super.e;
    }

    /**
     * Getter method for contactID.
     * @return the contactID attribute of this AddContactResponse object
     */
    public Long getContactID() {
        return contactID;
    }

    /**
     * Getter method for userID.
     * @return the userID attribute of this AddContactResponse object
     */
    public int getUserID() {
        return userID;
    }
}
