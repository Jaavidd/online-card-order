package onlinecardorder.dto.request;

import java.io.Serializable;

public class RegistrationControllerRequest implements Serializable {
    private Long cif;
    private String cardBin;
    private String cardName;
    private String bankName;

    @Override
    public String toString() {
        return "RegistrationControllerRequest{" +
                ", userId=" + cif +
                ", cardBin='" + cardBin + '\'' +
                ", cardName='" + cardName + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }

    public Long getCif() {
        return cif;
    }

    public RegistrationControllerRequest setCif(Long cif) {
        this.cif = cif;
        return this;
    }

    public String getCardBin() {
        return cardBin;
    }

    public RegistrationControllerRequest setCardBin(String cardBin) {
        this.cardBin = cardBin;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    public RegistrationControllerRequest setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public RegistrationControllerRequest setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }
}
