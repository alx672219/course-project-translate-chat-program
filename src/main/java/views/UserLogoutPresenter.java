package views;

import user_logout_use_case.UserLogoutOutputBoundary;

public class UserLogoutPresenter implements UserLogoutOutputBoundary {
    private final Navigator nav;

    public UserLogoutPresenter(Navigator nav) {
        this.nav = nav;
    }

    @Override
    public void prepareLoginScreen() {
        nav.showScreen("login");
    }
}
