package com.example.ecommerce.model.order;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="product_sold")
public class SoldProduct {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String item_id;
    private int quantity;
    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    public SoldProduct() {

    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
