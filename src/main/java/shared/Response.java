package shared;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Response {
    protected Exception e;
    protected LocalDateTime time = LocalDateTime.now();

    public abstract Exception getException();
    public String getTime() {
        return time.format(DateTimeFormatter.ofPattern("yyyy MM dd : HH mm ss"));
    }
}
