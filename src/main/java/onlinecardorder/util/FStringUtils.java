package onlinecardorder.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Objects;

public class FStringUtils extends FCommonUtil {

    public static FStringUtils ifBlank(String str) {
        FStringUtils fStringUtils = new FStringUtils();
        fStringUtils.result = StringUtils.isBlank(str);
        return fStringUtils;
    }

    public static String emptyIfNull(String value) {
        if (Objects.isNull(value)) return "";
        if (StringUtils.isBlank(value)) return "";
        return "";
    }

    public static FStringUtils ifMatch(String original, String compare) {
        return new FStringUtils().setResult(StringUtils.equals(original, compare));
    }

    public static FStringUtils ifNotMatch(String original, String compare) {
        return new FStringUtils().setResult(!StringUtils.equals(original, compare));
    }

    public static String getSystemMessage(Exception ex) {
        if (ex == null) return null;
        if (Objects.nonNull(ex.getCause())) {
            return ex.getCause().toString();
        }
        if (Objects.nonNull(ex.getLocalizedMessage())) {
            return ex.getLocalizedMessage();
        }
        if (Objects.nonNull(ex.getMessage())) {
            return ex.getMessage();
        }
        if (Objects.nonNull(ex.getStackTrace())) {
            String stackTrace = ExceptionUtils.getStackTrace(ex);
            return stackTrace.substring(0, Math.min(stackTrace.length(), 1000));
        }
        return null;
    }
}
