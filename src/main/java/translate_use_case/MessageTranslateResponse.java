package translate_use_case;

import shared.Response;

public class MessageTranslateResponse extends Response {
    private final String result;


    public String getResult() {
        return result;
    }
    @Override
    public Exception getException() {
        return e;
    }

    public MessageTranslateResponse(String result, boolean success, Exception e) {

        this.result = result;
        this.success = success;
        this.e = e;
    }
}
