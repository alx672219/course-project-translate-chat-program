package user_send_message;

import shared.Response;

/**
 * Class that models the response received from send message request
 */
public class SendMessageResponse extends Response {
    public int getMessageID() {
        return message_id;
    }

    public SendMessageResponse(int message_id, boolean success, Exception e) {
        this.message_id = message_id;
        this.success = success;
        this.e = e;
    }

    int message_id;


    @Override
    public Exception getException() {
        return super.e;
    }
}
