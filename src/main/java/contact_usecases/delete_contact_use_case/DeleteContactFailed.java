package contact_usecases.delete_contact_use_case;

public class DeleteContactFailed extends RuntimeException{

    /**
     * Constructor for DeleteContactFailed
     * @param error error message
     */
    public DeleteContactFailed(String error) {

        super(error);

    }
}
