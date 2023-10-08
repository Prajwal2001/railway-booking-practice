package railway.booking.app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CustomException extends Exception {
    
    private String message;

    public CustomException(String message) {
        this.message = message;
    }
}
