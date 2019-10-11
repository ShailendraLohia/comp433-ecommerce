package com.example.ecommerce.model.customer;

import com.example.ecommerce.model.customer.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
