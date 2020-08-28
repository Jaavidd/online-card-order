package onlinecardorder.dto.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RegisteredCardDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String fatherName;
    private LocalDate birthday;
    private String phoneNumber;
    private String url;
    private boolean fullyPaid;
    private String cardType;
    private String currency;
    private boolean partiallyPaid;
    private Double cardPrice;
    private Double balance;
    private static final long LIMIT = 100000000L;
    private static long last = 0;

    public boolean isFullyPaid() {
        return fullyPaid;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public RegisteredCardDto setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
    
    public static long getID() {
        // 8 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }
    public RegisteredCardDto setFullyPaid(boolean fullyPaid) {
        this.fullyPaid = fullyPaid;
        return this;
    }
    public Double getBalance() {
        return balance;
    }

    public RegisteredCardDto setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegisteredCardDto setId() {
        this.id = getID();
        return this;
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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredCardDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public String getUrl() {
        return url;
    }

    public RegisteredCardDto setUrl(String url) {
        this.url = url;
        return this;
    }

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

    public boolean isPartiallyPaid() {
        return partiallyPaid;
    }

    public RegisteredCardDto setPartiallyPaid(boolean partiallyPaid) {
        this.partiallyPaid = partiallyPaid;
        return this;
    }

    public Double getCardPrice() {
        return cardPrice;
    }

    public RegisteredCardDto setCardPrice(Double cardPrice) {
        this.cardPrice = cardPrice;
        return this;
    }
}
