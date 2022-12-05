package shared;

import java.util.List;

/**
 * Read only class that stores some fields related to a User in order to avoid
 * referencing the User class directly. Acts as a simplified version of the
 * STATE design pattern.
 */
public class UserDetails {
    public UserDetails(String username, int uid, String default_lang, List<Long> contacts) {
        this.username = username;
        this.userId = uid;
        this.default_lang = default_lang;
        this.contacts = contacts;
    }

    private final String username;
    private final int userId;
    private final String default_lang;

    public List<Long> getContacts() {
        return contacts;
    }

    private final List<Long> contacts;


    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public String getDefault_lang() {
        return default_lang;
    }
}
