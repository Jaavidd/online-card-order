package onlinecardorder.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "registered_cards")
public class RegisteredCardEntity {

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "fully_paid")
    private boolean fullyPaid;

    @Column(name="url")
    private String url;

    @Column(name = "card_type")
    private String cardType;

    @Column(name="currency")
    private String currency;


    @Column(name = "partially_paid")
    private boolean partiallyPaid;

    @Column(name="card_price")
    private Double cardPrice=100.0;

    @Column(name="balance")
    private Double balance=0.0;

    private static final long LIMIT = 100000000L;
    private static long last = 0;

    public static long getID() {
        // 8 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        return last = id;
    }
    public boolean isFullyPaid() {
        return fullyPaid;
    }

    public RegisteredCardEntity setFullyPaid(boolean fullyPaid) {
        this.fullyPaid = fullyPaid;
        return this;
    }
    public Double getBalance() {
        return balance;
    }

    public RegisteredCardEntity setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RegisteredCardEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisteredCardEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisteredCardEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public RegisteredCardEntity setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public RegisteredCardEntity setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredCardEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    @Override
    public String toString() {
        return "RegisteredCardEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fullyPaid=" + fullyPaid +
                ", url='" + url + '\'' +
                ", cardType='" + cardType + '\'' +
                ", currency='" + currency + '\'' +
                ", partiallyPaid=" + partiallyPaid +
                ", cardPrice=" + cardPrice +
                ", balance=" + balance +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public RegisteredCardEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public RegisteredCardEntity setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public RegisteredCardEntity setCurrency(String currency) {
        this.currency = currency;
        return this;
    }


    public boolean isPartiallyPaid() {
        return partiallyPaid;
    }

    public RegisteredCardEntity setPartiallyPaid(boolean partiallyPaid) {
        this.partiallyPaid = partiallyPaid;
        return this;
    }

    public Double getCardPrice() {
        return cardPrice;
    }

    public RegisteredCardEntity setCardPrice(Double cardPrice) {
        this.cardPrice = cardPrice;
        return this;
    }
}