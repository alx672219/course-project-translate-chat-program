package contact_usecases.add_contact_use_case;


import contact_usecases.delete_contact_use_case.DeleteContactFailed;

public interface AddContactOutputBoundary{

    /**
     * Method called when adding was successful.
     * @param response the AddContactResponse that needs to be mutated and returned
     * @return the mutated AddContactResponse
     */
    AddContactResponse prepareSuccessView(AddContactResponse response);

    /**
     * Method called when adding fails.
     * @param error error message that was raised
     * @throws AddContactFailed if search could not be made
     */
    AddContactResponse prepareFailView(String error);

}
