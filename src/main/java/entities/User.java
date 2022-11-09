package entities;

public class User {
    private String name;
    private String default_lang;
    private String email;
    private String password;

    public User(String name, String default_lang, String email, String password) {
        this.name = name;
        this.default_lang = default_lang;
        this.email = email;
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    public String getPassword() {
        return this.password;
    }
    public String getEmail() {
        return this.email;
    }
    public String getDefaultLang() {
        return this.default_lang;
    }

    public void setName(String s) {
        this.name = s;
    }
    public void setEmail(String s) {
        this.email = s;
    }
    public void setPassword(String s) {
        this.password = s;
    }
    public void setDefaultLang(String s) {
        this.default_lang = s;
    }
    // TODO: Add remaining User attributes as needed.
}
