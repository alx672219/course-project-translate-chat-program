package user_register_use_case;

public class UserRegistrationInteractor implements UserRegisterInputBoundary{
    private UserRegistrationGateway factory;

    public UserRegistrationInteractor(UserRegistrationGateway factory) {
        this.factory = factory;
    }

    @Override
    public RegisterResponse create(CreationData data) {
        boolean result = factory.create(data);
        // TODO: Complete Implementation of UserRegistrationInteractor.create
        return new RegisterResponse(data, false, null);
    }
}
