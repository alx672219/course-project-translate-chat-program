package shared;

/**
 * Read only class that stores some fields related to a User in order to avoid
 * referencing the User class directly.
 */
public class UserDetails {
    public UserDetails(String username, int uid, String default_lang) {
        this.username = username;
        this.userId = uid;
        this.default_lang = default_lang;
    }

    private final String username;
    private final int userId;
    private final String default_lang;


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
