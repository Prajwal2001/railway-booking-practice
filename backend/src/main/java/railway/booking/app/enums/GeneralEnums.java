package railway.booking.app.enums;

public enum GeneralEnums {

    DATE_FORMAT("dd-MM-yyyy HH:mm:ss"),
    BLANK(""),
    WHITE_SPACE(" ");

    private String stringValue1, stringValue2;

    GeneralEnums(String value1) {
        this.stringValue1 = value1;
    }

    GeneralEnums(String stringValue1, String stringValue2) {
        this.stringValue1 = stringValue1;
        this.stringValue2 = stringValue2;
    }

    public String getStringValue1() {
        return this.stringValue1;
    }

    public String getStringValue2() {
        return this.stringValue2;
    }
}
