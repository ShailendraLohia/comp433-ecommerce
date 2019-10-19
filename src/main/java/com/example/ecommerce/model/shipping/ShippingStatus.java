package com.example.ecommerce.model.shipping;

import com.example.ecommerce.model.order.Cart;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="shipping_status")
public class ShippingStatus {
    @Id
    private String trackingNumber;

    @OneToOne/*(mappedBy = "shippingDetails")*/
    @JoinColumn(name="cart_id",nullable = false)
    private Cart cart;

    private LocalDate shippingDate;
    private LocalDate arrivalDate;
    private String shippingStatus; // enum can be used
    private String shippedBy; // USPS, UPS, Fedex

    public ShippingStatus() {

    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public String getShippedBy() {
        return shippedBy;
    }

    public void setShippedBy(String shippedBy) {
        this.shippedBy = shippedBy;
    }
}
