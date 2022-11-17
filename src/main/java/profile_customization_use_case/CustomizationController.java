package profile_customization_use_case;

import entities.User;

import java.util.concurrent.ExecutionException;

public class CustomizationController {
    private final CustomizationInputBoundary cib;
    private final CustomizationOutputBoundary cob;

    public CustomizationController(CustomizationInputBoundary cib, CustomizationOutputBoundary cob) {
        this.cib = cib;
        this.cob = cob;
    }

    public void changeLanguage(User user, String language) throws ExecutionException, InterruptedException {
        this.cib.changeLanguage(user, language);
    }
    public void changeName(User user, String name) throws ExecutionException, InterruptedException {
        this.cib.changeName(user, name);
    }
    public void changePassword(User user, String password) throws ExecutionException, InterruptedException {
        this.cib.changePassword(user, password);
    }
}