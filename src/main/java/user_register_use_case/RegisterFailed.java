package user_register_use_case;

/**
 * Extension of RunTimeException that makes the code more readable.
 */
public class RegisterFailed extends RuntimeException{
    public RegisterFailed(String message) {
        super(message);
    }
}
