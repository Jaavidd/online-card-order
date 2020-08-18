package onlinecardorder.dto.request;
import java.io.Serializable;

public class RegistrationRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthday;
    private String phoneNumber;
    private String url;
    private String cardType;
    private String currency;
    private String password;

    public String getCardType() {
        return cardType;
    }

    public RegistrationRequest setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public RegistrationRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegistrationRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public RegistrationRequest setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegistrationRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegistrationRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RegistrationRequest setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public RegistrationRequest setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegistrationRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
