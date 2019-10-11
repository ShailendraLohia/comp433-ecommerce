package com.example.ecommerce.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="order_details")

public class Cart {
    @Id
    private String cartId;
    private String orderStatus;  //enum can be used
    private Date purchaseDate;

    @OneToOne
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST)
    private List<Items> items;

    @OneToOne
    @JoinColumn(name="trackingNumber", nullable = true)
    private ShippingDetails shippingDetails;

    public Cart() {

    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }
}
