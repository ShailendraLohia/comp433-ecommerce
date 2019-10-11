package com.example.ecommerce.model.shipping;

import com.example.ecommerce.model.order.Cart;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="shipping_details")
public class ShippingDetails {
    @Id
    private String trackingNumber;
    private String userId;

    //private String order_id;
    @OneToOne(mappedBy = "shippingDetails")
    private Cart cart;
    private Date shippingDate;
    private Date arrivalDate;
    private String shippingStatus; // enum can be used
    private String shippedBy; // USPS, UPS, Fedex

    public ShippingDetails() {

    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
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
