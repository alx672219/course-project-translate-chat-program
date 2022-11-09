package user_register_use_case;

public interface UserRegisterInputBoundary {
    /**
     * Attempts to create a User using the given CreationData.
     *
     * @param data the information used to create the User
     * @return
     */
    RegisterResponse create(CreationData data);
}
