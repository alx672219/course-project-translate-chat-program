package user_register_use_case;

import shared.Response;

public class RegisterResponse extends Response {

    public CreationData data;

    @Override
    public Exception getException() {
        return super.e;
    }

    public CreationData getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public RegisterResponse(CreationData data, boolean success, Exception e) {
        this.success = success;
        this.data = data;
        this.e = e;
    }
}
