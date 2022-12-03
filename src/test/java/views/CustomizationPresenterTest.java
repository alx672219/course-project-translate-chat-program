package views;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenters.CustomizationPresenter;
import profile_customization_use_case.CustomizationFailed;
import profile_customization_use_case.CustomizationResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomizationPresenterTest {

    private CustomizationPresenter presenter;

    @BeforeEach
    void setUp() {
        this.presenter = new CustomizationPresenter();
    }

    @Test
    void prepareSuccessView() {
        User user = new User("James", "en", "james@gmail.com", "password", 23);
        CustomizationResponse response = new CustomizationResponse(user.getName(), user.getDefault_lang(),
                                                                   user.getPassword(), true, null);
        Assertions.assertEquals(response, presenter.prepareSuccessView(response));
    }

    @Test
    void prepareFailView() {
        String error = "error occurred";
        Exception e = assertThrows(CustomizationFailed.class, () -> presenter.prepareFailView(error));
        Assertions.assertEquals(error, e.getMessage());
    }
}
