package com.example.ecommerce.model.customer;

import javax.persistence.*;

@Entity
//@Embeddable
@Table(name="address_details")
public class Address {
    @Id
    private String id;
    private String streetDetails;
    private String apt_number;
    private String city;
    private String state;
    private int zipCode;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User userId;

    public Address() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetDetails() {
        return streetDetails;
    }

    public void setStreetDetails(String streetDetails) {
        this.streetDetails = streetDetails;
    }

    public String getApt_number() {
        return apt_number;
    }

    public void setApt_number(String apt_number) {
        this.apt_number = apt_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
