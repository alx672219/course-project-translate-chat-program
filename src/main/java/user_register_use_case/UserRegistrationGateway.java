package user_register_use_case;

/**
 * Interface for the database used to create and store new users.
 */
public interface UserRegistrationGateway {
    boolean create(CreationData data);
}
