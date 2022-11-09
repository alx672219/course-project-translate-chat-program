package user_login_use_case;

public interface LoginInputBoundary {
    LoginResponse login(LoginData data);
}
