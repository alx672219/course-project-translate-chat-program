package contact_usecases.add_contact_use_case;


import contact_usecases.delete_contact_use_case.DeleteContactResponse;
import message_search_use_case.MessageSearchResponse;

public interface AddContactOutputBoundary{
    AddContactResponse prepareSuccessView(AddContactResponse response);
    AddContactResponse prepareFailView(String error);

}
