package user_login_use_case;

/**
 * Transient class that stores the data required for a login.
 */
public class LoginData {
    private final String username;
    private final String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginData(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
