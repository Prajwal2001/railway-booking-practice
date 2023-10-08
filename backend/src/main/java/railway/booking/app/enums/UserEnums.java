package railway.booking.app.enums;

public enum UserEnums {
    DUPLICATE_EMAIL_PHONE("The Email-Id: %s, and phone number: %s, are already registered"),
    DUPLICATE_EMAIL("The Email-Id: %s, is already registered"),
    DUPLICATE_PHNO("The phone number: %s, is already registered");

    private String message;

    private UserEnums(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
