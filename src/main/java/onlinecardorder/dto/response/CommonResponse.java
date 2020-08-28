package onlinecardorder.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import onlinecardorder.helper.BusinessResult;
import onlinecardorder.helper.BusinessStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;


public class CommonResponse implements Serializable {
    private Integer code;
    private BusinessResult.BusinessResultType type;
    private String message;
    private String systemMessage;
    private Object data;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public static ResponseEntity<CommonResponse> instance(BusinessResult businessResult, String lang) {
        return ResponseEntity.status(businessResult.getHttpStatus())
                .body(CommonResponse.instance(
                        businessResult.getCode(),
                        businessResult.getType(),
                        getMessage(businessResult, lang),
                        businessResult.getSystemMessage(),
                        businessResult.getResponseData()
                ));
    }

    private static CommonResponse instance(Integer code, BusinessResult.BusinessResultType type, String message, String systemMessage, Object data) {
        return new CommonResponse()
                .setCode(code)
                .setType(type)
                .setMessage(message)
                .setSystemMessage(systemMessage)
                .setData(data)
                .setTimestamp(LocalDateTime.now());
    }

    public static ResponseEntity<CommonResponse> success(Serializable data, String lang) {
        return instance(BusinessResult.of(BusinessStatus.SUCCESS_PROCESS, data), lang);
    }

    private static String getMessage(BusinessResult businessResult, String lang) {
        String message = businessResult.getMessageAz();
        if (lang != null) {
            if (lang.equalsIgnoreCase("en")) {
                message = businessResult.getMessageEn();
            } else if (lang.equalsIgnoreCase("ru")) {
                message = businessResult.getMessageRu();
            }
        }
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public CommonResponse setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

    public CommonResponse setSystemMessage(String systemMessage) {
        this.systemMessage = systemMessage;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public CommonResponse setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public BusinessResult.BusinessResultType getType() {
        return type;
    }

    public CommonResponse setType(BusinessResult.BusinessResultType type) {
        this.type = type;
        return this;
    }
}





