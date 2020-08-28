package onlinecardorder.util;

public class FConditionUtil extends FCommonUtil {

    public static FConditionUtil ifNotTrue(boolean condition) {
        FConditionUtil util = new FConditionUtil();
        util.result = !condition;
        return util;
    }

    public static FConditionUtil ifTrue(boolean condition) {
        FConditionUtil util = new FConditionUtil();
        util.result = condition;
        return util;
    }

}
