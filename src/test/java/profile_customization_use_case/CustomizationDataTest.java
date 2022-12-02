package profile_customization_use_case;

import entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CustomizationDataTest {

    private CustomizationData data;

    @BeforeEach
    void setUp() {
        User user = new User();
        this.data = new CustomizationData("John", "English", "hello123", user);
    }

    @Test
    void getName() {
        assert(data.getName().equals("John"));
    }

    @Test
    void getDefaultLang() {
        assert(data.getDefaultLang().equals("English"));
    }

    @Test
    void getPassword() {
        assert(data.getPassword().equals("hello123"));
    }
}
