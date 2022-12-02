package contact_usecases.delete_contact_use_case;


public interface DeleteContactOutputBoundary {

    /**
     * Method called when deleting was successful.
     * @param response the DeleteContactResponse that needs to be mutated and returned
     * @return the mutated DeleteContactResponse
     */
    DeleteContactResponse prepareSuccessView(DeleteContactResponse response);

    /**
     * Method called when deleting fails.
     * @param error error message that was raised
     * @throws DeleteContactFailed if search could not be made
     */
    DeleteContactResponse prepareFailView(String error);

}