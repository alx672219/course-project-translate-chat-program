package user_login_use_case;

/**
 * An interface for the Login presenter.
 */
public interface LoginOutputBoundary {
    /**
     * Returns a response to the login view indicating an error with the given error message
     * @param error the error message to be displayed
     * @return A LoginResponse with a given error message
     */
    LoginResponse prepareFailView(String error);

    /**
     * Return a response to the login view indicating a success.
     * @param response the response received from the login request
     * @return the response received from the request
     */
    LoginResponse prepareSuccessView(LoginResponse response);

}
