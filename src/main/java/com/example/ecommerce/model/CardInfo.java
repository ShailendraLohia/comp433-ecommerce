package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="card_info")
public class CardInfo {
    @Id
    private String cardNumber;
    @Id
    private String cardType; // Debit, Credit
    private String cardCategory; // Visa, mastercard
    private Date ExpirationDate;
    private String userId;
}
