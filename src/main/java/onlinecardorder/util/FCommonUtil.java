package onlinecardorder.util;


import onlinecardorder.helper.BusinessException;
import onlinecardorder.helper.BusinessStatus;

public class FCommonUtil {
    boolean result;

    public FCommonUtil exec(Runnable runnable) {
        if (result) {
            runnable.run();
        }
        return this;
    }

    public void elseExec(Runnable runnable) {
        if (!result) {
            runnable.run();
        }
    }

    public void throwEx(BusinessException ex) {
        if (result) {
            ex.throwEx();
        }
    }

    public void throwEx(Exception ex) {
        if (result) {
            throw BusinessException.of(ex);
        }
    }

    public void throwEx(BusinessStatus status) {
        throwEx(BusinessException.of(status));
    }

    public <T> T setResult(boolean result) {
        this.result = result;
        return (T) this;
    }
}
