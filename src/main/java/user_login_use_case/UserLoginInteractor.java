package user_login_use_case;

import java.io.IOException;

public class UserLoginInteractor implements LoginInputBoundary {
    private final UserLoginGateway auth;
    private final LoginOutputBoundary presenter;

    public UserLoginInteractor(UserLoginGateway auth, LoginOutputBoundary presenter) {
        this.presenter = presenter;
        this.auth = auth;
    }

    @Override
    public LoginResponse login(LoginData data) {
        try {
            LoginResponse resp = auth.login(data);
            if (resp.isSuccess()) {
                return presenter.prepareSuccessView(resp);
            } else {
                return presenter.prepareFailView(resp.getException().getMessage());
            }
        } catch (RuntimeException e) {
            return presenter.prepareFailView(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
