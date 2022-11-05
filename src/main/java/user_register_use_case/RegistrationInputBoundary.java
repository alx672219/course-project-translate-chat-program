package user_register_use_case;

public interface RegistrationInputBoundary {
    RegisterResponse register(CreationData data);
}
