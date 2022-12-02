package contact_usecases.delete_contact_use_case;;

public interface DeleteContactOutputBoundary {
    DeleteContactResponse prepareSuccessView(DeleteContactResponse response);

    DeleteContactResponse prepareFailView(String error);

}