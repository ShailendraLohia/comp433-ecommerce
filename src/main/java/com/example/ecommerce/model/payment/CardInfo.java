package com.example.ecommerce.model.payment;

import com.example.ecommerce.model.customer.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="card_info")
public class CardInfo implements Serializable {
    @Id
    private String cardNumber;
    @Id
    private String cardType; // Debit, Credit
    private String cardCategory; // Visa, mastercard
    private Date expiryDate;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    //@EqualsAndHashCode.Include private User user;
    private User user;

    public CardInfo() {

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardCategory() {
        return cardCategory;
    }

    public void setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
