package onlinecardorder.helper;


import onlinecardorder.util.FStringUtils;

public class BusinessException extends RuntimeException {

    private final BusinessResult result;

    private BusinessException(BusinessResult result) {
        super(result.getSystemMessage());
        this.result = result;
    }

    public static BusinessException of(BusinessStatus status) {
        return new BusinessException(BusinessResult.of(status));
    }

    public static BusinessException of(BusinessResult businessResult) {
        return new BusinessException(businessResult);
    }

    public static BusinessException of(Exception e, BusinessStatus businessStatus) {
        BusinessResult br = BusinessResult.of(businessStatus);
        e.printStackTrace();
        br.setSystemMessage(br.getSystemMessage() + ";" + FStringUtils.getSystemMessage(e));
        return new BusinessException(br);
    }

    public static BusinessException of(Exception e) {
        return of(e, BusinessStatus.ERROR_INTERNAL);
    }

    public void throwEx() {
        throw this;
    }

    public BusinessResult getBusinessResult() {
        return result;
    }
}
