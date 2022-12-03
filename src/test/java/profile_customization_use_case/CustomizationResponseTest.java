package profile_customization_use_case;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomizationResponseTest {

    private CustomizationResponse response;

    @BeforeEach
    void setUp() {
        this.response = new CustomizationResponse("Jake", "en", "password1", true, null, 0);
    }

    @Test
    void getName() {
        Assertions.assertEquals("Jake", response.getName());
    }

    @Test
    void getDefaultLang() {
        Assertions.assertEquals("en", response.getDefaultLanguage());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("password1", response.getPassword());
    }

    @Test
    void getException() {
        Assertions.assertNull(response.getException());
    }
}
