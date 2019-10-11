package com.example.ecommerce.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "customer_info")
public class User {
    @Id
    private String userId;
    private String userName;
    private Date dateOfBirth;
    private boolean primeMember;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<CardInfo> paymentDetails;

    @OneToMany(mappedBy = "userId")
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride( name = "streetDetails", column = @Column(name = "streetDetails")),
//            @AttributeOverride( name = "apt_number", column = @Column(name = "apt_number")),
//            @AttributeOverride( name = "city", column = @Column(name = "city")),
//            @AttributeOverride( name = "state", column = @Column(name = "state")),
//            @AttributeOverride( name = "zipCode", column = @Column(name = "zipCode"))
//    })
    private List<Address> addresses;

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isPrimeMember() {
        return primeMember;
    }

    public void setPrimeMember(boolean primeMember) {
        this.primeMember = primeMember;
    }

    public Set<CardInfo> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Set<CardInfo> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
