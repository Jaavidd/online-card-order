package onlinecardorder.entity;


import onlinecardorder.dto.request.RegistrationRequest;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Entity
@Table(name = "registered_cards")
public class RegisteredCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "birthday")
//    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String bithday;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_paid")
    private boolean isPaid = false;

    @Column(name="url")
    private String url;

    @Column(name = "card_type")
    private String cardType;
    @Column(name="currency")
    private String currency;

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

    public String getUrl() {
        return url;
    }

    public RegisteredCardEntity setUrl(String url) {
        this.url = url;
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

    public String getBithday() {
        return bithday;
    }

    public RegisteredCardEntity setBithday(String bithday) {
        this.bithday = bithday;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public RegisteredCardEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public RegisteredCardEntity setPaid(boolean paid) {
        isPaid = paid;
        return this;
    }



}