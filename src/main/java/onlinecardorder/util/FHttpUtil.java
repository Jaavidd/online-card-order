package onlinecardorder.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

public class FHttpUtil extends FCommonUtil {

    public static boolean isResponseSuccess(ResponseEntity responseEntity) {
        return (responseEntity.getStatusCode().is2xxSuccessful() && Objects.nonNull(responseEntity.getBody()));
    }

    public static FHttpUtil ifHttpStatusIsSuccess(ResponseEntity responseEntity) {
        return new FHttpUtil().setResult(isResponseSuccess(responseEntity));
    }

    public static FHttpUtil ifHttpStatusIsError(ResponseEntity responseEntity) {
        return new FHttpUtil().setResult(!isResponseSuccess(responseEntity));
    }

    public static FHttpUtil ifHttpStatusIs(ResponseEntity responseEntity, HttpStatus httpStatus) {
        return new FHttpUtil().setResult(responseEntity.getStatusCode() == httpStatus);
    }
}
