package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="order_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    private String cartId;
    private String user_id;
    private String orderStatus;  //enum can be used
    private Date purchaseDate;
    //private CardInfo paymentInfo; // could be use for request object
    @OneToMany(mappedBy = "cart")
    private Set<Items> items;
}
