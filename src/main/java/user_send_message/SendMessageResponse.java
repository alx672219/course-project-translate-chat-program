package user_send_message;

import entities.Message;
import shared.Response;

/**
 * Class that models the response received from send message request
 */
public class SendMessageResponse extends Response {
    public Message getMessage() {
        return message;
    }

    public SendMessageResponse(Message message, boolean success, Exception e) {
        this.message = message;
        this.success = success;
        this.e = e;
    }

    Message message;


    @Override
    public Exception getException() {
        return super.e;
    }
}
