package onlinecardorder.util;

import org.apache.commons.lang3.ObjectUtils;

public class FObjectUtils extends FCommonUtil {

    public static FObjectUtils ifNull(Object obj) {
        FObjectUtils fStringUtils = new FObjectUtils();
        fStringUtils.result = obj == null;
        return fStringUtils;
    }

    public static FObjectUtils ifNotNull(Object obj) {
        FObjectUtils fStringUtils = new FObjectUtils();
        fStringUtils.result = obj != null;
        return fStringUtils;
    }

    public static FObjectUtils ifNotEquals(Object objCompare, Object objExpected) {
        FObjectUtils fStringUtils = new FObjectUtils();
        fStringUtils.result = ObjectUtils.notEqual(objCompare, objExpected);
        return fStringUtils;
    }


}
