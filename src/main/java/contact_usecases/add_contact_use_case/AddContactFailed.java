package contact_usecases.add_contact_use_case;

public class AddContactFailed extends RuntimeException {

    /**
     * Constructor for AddContactFailed
     * @param error error message
     */
    public AddContactFailed(String error) {
        super(error);
    }
}
