package railway.booking.app.enums;

public enum UserEnums {
    // Registration
    DUPLICATE_EMAIL_PHONE("The Email-Id: %s, and phone number: %s, are already registered"),
    DUPLICATE_EMAIL("The Email-Id: %s, is already registered"),
    DUPLICATE_PHNO("The phone number: %s, is already registered"),
    
    // Login
    INVALID_PASSWORD("Invalid password"),
    INVALID_USER("Invalid user, Email-ID: %s not found"),

    // User types
    ADMIN_ROLE("ADMIN"),
    USER_ROLE("USER");

    private String value;

    private UserEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
