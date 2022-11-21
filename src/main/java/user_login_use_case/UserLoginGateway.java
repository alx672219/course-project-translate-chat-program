package user_login_use_case;

import java.io.IOException;

public interface UserLoginGateway {
    LoginResponse login(LoginData data) throws IOException;
}
