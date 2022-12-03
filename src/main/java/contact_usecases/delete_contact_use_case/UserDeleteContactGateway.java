package contact_usecases.delete_contact_use_case;

import java.util.List;

public interface UserDeleteContactGateway {

    /**
     * Deletes contactIDs that match userID in data
     * @param userID DeleteContactData object that tells method which userID to look for
     * @param contactID DeleteContactData object that tells method which contactID to delete
     * @return userID and contactID that match data
     */
    List<Integer> deleteContact(Integer userID, Integer contactID);


}
