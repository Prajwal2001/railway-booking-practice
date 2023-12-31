package railway.booking.app.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import railway.booking.app.enums.LogEnums;
import railway.booking.app.enums.GeneralEnums;

@Component
public class Log {

    private Date curDate;
    private String className;
    private String methodName;
    private int lineNumber;
    private SimpleDateFormat simpleDateFormat;
    private String formattedDate;
    private StackTraceElement stackTraceElement;

    public void info(Object message) {
        print(LogEnums.INFO_LOG_FORMAT, message);
    }

    public void error(Object message) {
        print(LogEnums.ERROR_LOG_FORMAT, message);
    }

    public void print(LogEnums logEnums, Object message) {
        fetchBasicData();

        System.out.println("");
        System.out.println(
                String.format(logEnums.getStringValue1(), formattedDate, className,
                        lineNumber, methodName, message));
        System.out.println("");

    }

    private void fetchBasicData() {
        stackTraceElement = Thread.currentThread().getStackTrace()[4];
        curDate = new Date();
        className = stackTraceElement.getClassName();
        methodName = stackTraceElement.getMethodName();
        lineNumber = stackTraceElement.getLineNumber();
        simpleDateFormat = new SimpleDateFormat(GeneralEnums.DATE_FORMAT.getStringValue1());
        formattedDate = simpleDateFormat.format(curDate);
    }
}
