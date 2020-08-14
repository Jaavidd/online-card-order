package onlinecardorder.mobilshobe;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class StoredCardsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "card_bin")
    private String cardBin;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "card_bank_name")
    private String CardBankName;

    @Column(name = "token")
    private String token;

    @Column(name = "masked_pan")
    private String maskedPan;

    @Column(name = "expire_date")
    private String expireDate;

    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @Column(name = "create_date", nullable = false, updatable = false)
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    public String getToken() {
        return token;
    }

    public StoredCardsEntity setToken(String token) {
        this.token = token;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public StoredCardsEntity setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }


    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public StoredCardsEntity setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
        return this;
    }


    public Long getOrderId() {
        return orderId;
    }

    public StoredCardsEntity setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public StoredCardsEntity setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCardBin() {
        return cardBin;
    }

    public StoredCardsEntity setCardBin(String cardBin) {
        this.cardBin = cardBin;
        return this;
    }

    public String getCardName() {
        return cardName;
    }

    public StoredCardsEntity setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getCardBankName() {
        return CardBankName;
    }

    public StoredCardsEntity setCardBankName(String cardBankName) {
        CardBankName = cardBankName;
        return this;
    }


    public String getMaskedPan() {
        return maskedPan;
    }

    public StoredCardsEntity setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
        return this;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public StoredCardsEntity setExpireDate(String expireDate) {
        this.expireDate = expireDate;
        return this;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public StoredCardsEntity setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
        return this;
    }

}