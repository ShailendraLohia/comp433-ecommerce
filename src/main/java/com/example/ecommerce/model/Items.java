package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    private String item_id;
    private int quantity;
//    private boolean returnItem;
    @ManyToOne
    @JoinColumn(name="cartId", nullable = false)
    private Cart cart;
}
