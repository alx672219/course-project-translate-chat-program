package contact_usecases.add_contact_use_case;

public class AddContactFailed extends RuntimeException {


    public AddContactFailed(String error) {
        super(error);
    }
}
