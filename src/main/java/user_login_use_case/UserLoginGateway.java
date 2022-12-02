package user_login_use_case;

import java.io.IOException;

/**
 * Interface for accessing the database for user authentication.
 */
public interface UserLoginGateway {
    /**
     * Attempts to log the user in using the given data.
     * @param data the data used to log the user in
     * @return a response indicating whether the request was successful
     * @throws IOException in case the database could not be accessed
     */
    LoginResponse login(LoginData data) throws IOException;
}
