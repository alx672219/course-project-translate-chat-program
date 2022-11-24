package contact_usecases.delete_contact_use_case;

public class DeleteContactFailed extends RuntimeException{


    public DeleteContactFailed(String error) {

        super(error);

    }
}
