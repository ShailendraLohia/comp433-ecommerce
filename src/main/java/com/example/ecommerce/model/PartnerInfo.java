package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="partner_details")
public class PartnerInfo {
    @Id
    private String partnerId;
    private String partnerName;
    //private Address address;
}
