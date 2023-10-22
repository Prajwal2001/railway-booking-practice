package railway.booking.app.enums;

public enum JWTEnums {
    USER_CLAIM("user"),
    ROLES_CLAIM("roles"),
    ISSUER("self"),
    ROLE_PREFIX("ROLE_");

    private String value;

    private JWTEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
