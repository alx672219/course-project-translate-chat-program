package user_login_use_case;

/**
 * Extension of RunTimeException that makes the code more readable.
 */
public class LoginFailed extends RuntimeException {
    public LoginFailed(String message) {
        super(message);
    }
}
