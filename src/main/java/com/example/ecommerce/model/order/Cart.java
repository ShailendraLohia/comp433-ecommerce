package com.example.ecommerce.model.order;

import com.example.ecommerce.model.customer.User;

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

    @OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<SoldProduct> items;

//    @OneToOne
//    @JoinColumn(name="trackingNumber", nullable = true)
//    private ShippingStatus shippingDetails;

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

    public List<SoldProduct> getItems() {
        return items;
    }

    public void setItems(List<SoldProduct> items) {
        this.items = items;
    }

//    public ShippingStatus getShippingDetails() {
//        return shippingDetails;
//    }
//
//    public void setShippingDetails(ShippingStatus shippingDetails) {
//        this.shippingDetails = shippingDetails;
//    }
}
