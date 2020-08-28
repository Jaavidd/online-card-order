package onlinecardorder.dto.response;

import java.io.Serializable;

public class PaymentResponse implements Serializable {
    private Long id;
    private String message;

    public Long getId() {
        return id;
    }

    public PaymentResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PaymentResponse setMessage(String message) {
        this.message = message;
        return this;
    }
}
