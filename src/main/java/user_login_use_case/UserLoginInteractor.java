package user_login_use_case;

class UserLoginInteractor implements LoginInputBoundary {
    private UserLoginGateway auth;

    public UserLoginInteractor(UserLoginGateway auth) {
        this.auth = auth;
    }

    @Override
    public LoginResponse login(LoginData data) {
        // TODO: Complete Pre/Post-checks cf. paulgries/UserLoginCleanArchitecture
        return auth.login(data);
    }
}
