package railway.booking.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import railway.booking.enums.GeneralEnums;
import railway.booking.enums.LogEnums;

@Component
public class Log {

    Date curDate;
    private String className;
    private String methodName;
    private int lineNumber;
    private SimpleDateFormat simpleDateFormat;
    private String formattedDate;
    private StackTraceElement stackTraceElement;

    public void info(Object obj) {
        print(LogEnums.INFO_LOG_FORMAT, obj);
    }

    public void error(Object obj) {
        print(LogEnums.ERROR_LOG_FORMAT, obj);
    }

    public void print(LogEnums logEnums, Object obj) {
        fetchBasicData();

        System.out.println("");
        System.out.println(
                String.format(logEnums.getStringValue1(), formattedDate, className,
                        lineNumber, methodName, obj));
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
