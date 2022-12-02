package user_login_use_case;

import java.io.IOException;

/**
 * Use case interactor for user login.
 */
public class UserLoginInteractor implements LoginInputBoundary {
    /**
     * The authentication gateway.
     */
    private final UserLoginGateway auth;
    /**
     * The presenter which is updated after login.
     */
    private final LoginOutputBoundary presenter;

    public UserLoginInteractor(UserLoginGateway auth, LoginOutputBoundary presenter) {
        this.presenter = presenter;
        this.auth = auth;
    }

    /**
     * Attempts to log in a user using the given data.
     * @param data the data that will be used to log in the user.
     * @return a response indicating whether the login was successful or not.
     */
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
