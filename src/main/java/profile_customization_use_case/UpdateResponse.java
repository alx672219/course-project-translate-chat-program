package profile_customization_use_case;

import shared.Response;

public class UpdateResponse extends Response {

    private String name;
    private String language;
    private String password;

    public UpdateResponse(String name, String language, String password) {
        this.name = name;
        this.language = language;
        this.password = password;
    }

    @Override
    public Exception getException() {
        return null;
    }
}
