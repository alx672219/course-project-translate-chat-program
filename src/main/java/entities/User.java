package entities;

public class User {
    private String name;
    private String default_lang;
    private String email;
    private String password;

    String getName() {
        return this.name;
    }
    String getPassword() {
        return this.password;
    }
    String getEmail() {
        return this.email;
    }
    String getDefaultLang() {
        return this.default_lang;
    }

    void setName(String s) {
        this.name = s;
    }
    void setEmail(String s) {
        this.email = s;
    }
    void setPassword(String s) {
        this.password = password;
    }
    void setDefaultLang(String s) {
        this.default_lang = s;
    }
    // TODO: Add remaining User attributes as needed.
}
