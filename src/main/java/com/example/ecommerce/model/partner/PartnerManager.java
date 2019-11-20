package com.example.ecommerce.model.partner;

import com.example.ecommerce.dal.partner.PartnerDAOImpl;

import java.time.Instant;

public class PartnerManager {

    private PartnerDAOImpl partnerDAO = new PartnerDAOImpl();

    public String savePartnerInfo(PartnerInfo partnerInfo) {
        String partnerId=String.valueOf(Instant.now().toEpochMilli())
                +partnerInfo.getPartnerName();

        partnerInfo.setPartnerId(partnerId);

        return partnerDAO.savePartnerInfo(partnerInfo);
    }
}
