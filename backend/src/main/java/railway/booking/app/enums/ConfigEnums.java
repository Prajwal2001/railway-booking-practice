package railway.booking.app.enums;

public enum ConfigEnums {
    AUTH_ROUTES("/auth/**"),
    SWAGGER_UI_ROUTES("/swagger-ui/**"),
    API_DOCS_ROUTES("/v3/api-docs/**"),
    ADMIN_ROUTES("/admin/**"),
    USER_ROUTES("/user/**");

    private String value;

    private ConfigEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
