package onlinecardorder.dto.entity;

import onlinecardorder.dto.request.RegistrationRequest;
import onlinecardorder.entity.RegisteredCardEntity;

import java.time.LocalDate;

public class RegisteredCardDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String birthday;
    private String phoneNumber;
    private boolean isPaid = false;
    private String url;
    private String cardType;
    private String currency;

    public String getCardType() {
        return cardType;
    }

    public RegisteredCardDto setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public RegisteredCardDto setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


    public String getUrl() {
        return url;
    }

    public RegisteredCardDto setUrl(String url) {
        this.url = url;
        return this;
    }
    public Long getId() {
        return id;
    }

    public RegisteredCardDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisteredCardDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisteredCardDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RegisteredCardDto setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getBithday() {
        return birthday;
    }

    public RegisteredCardDto setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredCardDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public RegisteredCardDto setPaid(boolean paid) {
        isPaid = paid;
        return this;
    }
}
