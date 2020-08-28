package onlinecardorder.helper;

import org.springframework.http.HttpStatus;

public enum BusinessStatus {
    ERROR_INTERNAL(-117, HttpStatus.INTERNAL_SERVER_ERROR, BusinessStatusType.ERROR, "Daxili Xəta", "Internal Error", null),
    ERROR_NO_SUCH_UNICODE(404,HttpStatus.NOT_FOUND,BusinessStatusType.ERROR,"unikod mövcud deyil","unicode does not exist",null),

    SUCCESS_PROCESS(200, HttpStatus.OK, BusinessStatusType.SUCCESS, "SUCCESS", "SUCCESS", "SUCCESS"),
    ;

    public final Integer code;
    public final BusinessStatusType type;
    public final HttpStatus httpStatus;
    public final String systemMessage;
    public final String messageAz;
    public final String messageEn;
    public final String messageRu;

    BusinessStatus(Integer code, HttpStatus httpStatus, BusinessStatusType type, String messageAz, String messageEn, String messageRu) {
        this.code = code;
        this.type = type;
        this.httpStatus = httpStatus;
        this.messageAz = messageAz;
        this.messageEn = messageEn;
        this.messageRu = messageRu;
        this.systemMessage = messageEn;
    }

    BusinessStatus(Integer code, HttpStatus httpStatus, BusinessStatusType type, String messageAz, String messageEn, String messageRu, String systemMessage) {
        this.code = code;
        this.type = type;
        this.httpStatus = httpStatus;
        this.messageAz = messageAz;
        this.messageEn = messageEn;
        this.messageRu = messageRu;
        this.systemMessage = systemMessage;
    }

    public enum BusinessStatusType {
        ERROR, SUCCESS
    }

}
