package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "UserInfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String userId;
    private String userName;
    private Date DOB;
    private boolean primeMember;
    @OneToMany(mappedBy = "userId")
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

}
