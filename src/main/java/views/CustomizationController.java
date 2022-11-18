package views;

import entities.User;
import profile_customization_use_case.CustomizationData;
import profile_customization_use_case.CustomizationInputBoundary;

import java.util.concurrent.ExecutionException;

public class CustomizationController {
    private final CustomizationInputBoundary cib;
    private final CustomizationData data;

    public CustomizationController(CustomizationInputBoundary cib, CustomizationData data) {
        this.cib = cib;
        this.data = data;
    }

    public void changeLanguage(CustomizationData data) throws ExecutionException, InterruptedException {
        this.cib.changeLanguage(data);
    }
    public void changeName(CustomizationData data) throws ExecutionException, InterruptedException {
        this.cib.changeName(data);
    }
    public void changePassword(CustomizationData data) throws ExecutionException, InterruptedException {
        this.cib.changePassword(data);
    }
}