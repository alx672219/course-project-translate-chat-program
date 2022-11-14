package gateways;

import user_login_use_case.LoginData;
import user_login_use_case.LoginResponse;
import user_login_use_case.UserLoginGateway;

import java.io.IOException;

public class UserLoginFirebaseSystem implements UserLoginGateway {

    @Override
    public LoginResponse login(LoginData data) throws IOException {
        return null;
    }
}
