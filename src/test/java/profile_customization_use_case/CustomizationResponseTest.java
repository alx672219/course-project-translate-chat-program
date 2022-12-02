package profile_customization_use_case;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CustomizationResponseTest {

    private CustomizationResponse response;

    @BeforeEach
    void setUp() {
        this.response = new CustomizationResponse("Jake", "en", "password1", true, null);
    }

    @Test
    void getName() {
        assertEquals("Jake", response.getName());
    }

    @Test
    void getDefaultLang() {
        assertEquals("en", response.getDefaultLanguage());
    }

    @Test
    void getPassword() {
        assertEquals("password1", response.getPassword());
    }

    @Test
    void getException() {
        assertNull(response.getException());
    }
}
