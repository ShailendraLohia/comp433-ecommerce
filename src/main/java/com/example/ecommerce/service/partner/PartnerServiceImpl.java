package com.example.ecommerce.service.partner;

import com.example.ecommerce.dal.partner.PartnerDAOImpl;
import com.example.ecommerce.model.partner.PartnerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl {

    @Autowired
    private PartnerDAOImpl partnerDAO;

    public String addPartnerData(PartnerInfo partnerInfo) {

        return partnerDAO.savePartnerInfo(partnerInfo);
    }
}
