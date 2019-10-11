package com.example.ecommerce.model.partner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="partner_details")
public class PartnerInfo {
    @Id
    private String partnerId;
    private String partnerName;
    //private Address address;

    public PartnerInfo() {}

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
