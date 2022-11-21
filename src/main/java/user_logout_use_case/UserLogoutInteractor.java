package user_logout_use_case;

public class UserLogoutInteractor implements UserLogoutInputBoundary {
    private final UserLogoutOutputBoundary presenter;

    public UserLogoutInteractor(UserLogoutOutputBoundary presenter) {
        this.presenter = presenter;
    }

    @Override
    public void logout() {
        presenter.prepareLoginScreen();
    }
}
