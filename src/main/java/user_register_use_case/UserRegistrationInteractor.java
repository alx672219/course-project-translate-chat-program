package user_register_use_case;

/**
 * The use case interactor for registering new users.
 */
public class UserRegistrationInteractor implements UserRegisterInputBoundary{
    /**
     * The gateway through which new users will be created and stored.
     */
    private final UserRegistrationGateway factory;
    /**
     * The presenter that is updated after the request.
     */
    private final UserRegisterOutputBoundary presenter;

    public UserRegistrationInteractor(UserRegistrationGateway factory, UserRegisterOutputBoundary presenter) {
        this.factory = factory;
        this.presenter = presenter;
    }

    /**
     * Attemps to create a new user using the given data.
     * @param data the information used to create the User
     * @return a response indicating whether the new user was successfully created
     */
    @Override
    public RegisterResponse create(CreationData data) {
        try {
            boolean result = factory.create(data);
            if (!result) {
                return presenter.prepareFailView("Username is already in use");
            }
            return presenter.prepareSuccessView(new RegisterResponse(data, result, null));
        } catch (Exception e) {
            return presenter.prepareFailView(e.getMessage());
        }
    }
}
