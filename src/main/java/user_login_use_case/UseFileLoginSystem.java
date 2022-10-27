package user_login_use_case;

class UseFileLoginSystem implements UserLoginGateway{
    // TODO: Finish implementation of UserFileLoginSystem

    @Override
    public LoginResponse login(LoginData data) {
        return new LoginResponse(data.getUsername(), data.getPassword(), null);
    }
}
