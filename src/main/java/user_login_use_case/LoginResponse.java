package user_login_use_case;

import entities.User;
import shared.Response;

public class LoginResponse extends Response {
    private final LoginData data;
    private final User user;

    public Exception getException() {
        return super.e;
    }

    public LoginData getData() {
        return data;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isSuccess() { return success; }

    public LoginResponse(User user, LoginData data, boolean success, Exception e) {
        this.user = user;
        this.data = data;
        this.success = success;
        this.e = e;
    }

}
