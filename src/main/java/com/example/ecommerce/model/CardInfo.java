package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="card_info")
public class CardInfo implements Serializable {
    @Id
    private String cardNumber;
    @Id
    private String cardType; // Debit, Credit
    private String cardCategory; // Visa, mastercard
    private Date ExpirationDate;
    @ManyToOne
    @JoinColumn(name="userId")
    private User userId;
}
