package user_login_use_case;

public interface UserLoginGateway {
    LoginResponse login(LoginData data);
}
