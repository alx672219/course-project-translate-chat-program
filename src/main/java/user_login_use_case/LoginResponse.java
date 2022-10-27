package user_login_use_case;

import shared.Response;

public class LoginResponse extends Response {
    private String username;
    private String password;

    public Exception getException() {
        return super.e;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LoginResponse(String username, String password, Exception e) {
        this.username = username;
        this.password = password;
        this.e = e;
    }

}
