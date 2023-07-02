package railway.booking.enums;

public enum LogEnums {

    // Font colors
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    MAGENTA("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    DEFAULT("\u001B[0m"),

    // Background colors
    BLACK_BACKGROUND("\u001B[40m"),
    RED_BACKGROUND("\u001B[41m"),
    GREEN_BACKGROUND("\u001B[42m"),
    YELLOW_BACKGROUND("\u001B[43m"),
    BLUE_BACKGROUND("\u001B[44m"),
    MAGENTA_BACKGROUND("\u001B[45m"),
    CYAN_BACKGROUND("\u001B[46m"),
    WHITE_BACKGROUND("\u001B[47m"),

    // Logger constants
    INFO_LOG_FORMAT(GREEN_BACKGROUND.getStringValue1() + "[INFO]" + DEFAULT.getStringValue1() + " %s, "
            + GREEN.getStringValue1() + "%s.java:%d" + DEFAULT.getStringValue1() + " [%s] =>\n%s"),
    ERROR_LOG_FORMAT(RED_BACKGROUND.getStringValue1() + "[ERROR]" + DEFAULT.getStringValue1() + " %s, "
            + RED.getStringValue1() + "%s.java:%d" + DEFAULT.getStringValue1() + " [%s] =>\n%s");

    private String stringValue1, stringValue2;

    LogEnums(String value1) {
        this.stringValue1 = value1;
    }

    LogEnums(String stringValue1, String stringValue2) {
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
