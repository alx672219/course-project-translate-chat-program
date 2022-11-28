package profile_customization_use_case;

import shared.Response;

public class CustomizationResponse extends Response {

    private final String name;
    private final String default_language;
    private final String password;

    public CustomizationResponse(String name, String default_language, String password, boolean success, Exception e) {
        this.name = name;
        this.default_language = default_language;
        this.password = password;
        this.success = success;
        this.e = e;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public Exception getException() {
        return super.e;
    }

    public String getDefault_language() {
        return default_language;
    }
}
