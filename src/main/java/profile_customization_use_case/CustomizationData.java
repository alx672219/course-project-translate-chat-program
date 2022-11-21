package profile_customization_use_case;

import entities.User;

public class CustomizationData {

    private String name;
    private String default_lang;
    private String password;
    private User user;

    public CustomizationData(String name, String default_lang, String password, User user) {
        this.name = name;
        this.default_lang = default_lang;
        this.password = password;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getDefaultLang() {
        return default_lang;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }
}
