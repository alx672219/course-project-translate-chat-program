package user_login_use_case;

import shared.Response;
import shared.UserDetails;

/**
 * Transient class that models the response received from a
 * login request.
 */
public class LoginResponse extends Response {
    private final LoginData data;
    private final UserDetails details;

    public Exception getException() {
        return super.e;
    }

    public LoginData getData() {
        return data;
    }

    public UserDetails getDetails() {
        return this.details;
    }

    public boolean isSuccess() { return success; }

    public LoginResponse(UserDetails details, LoginData data, boolean success, Exception e) {
        this.details = details;
        this.data = data;
        this.success = success;
        this.e = e;
    }

}
