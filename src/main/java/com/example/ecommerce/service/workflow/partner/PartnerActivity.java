package com.example.ecommerce.service.workflow.partner;

import com.example.ecommerce.dal.partner.PartnerDAOImpl;
import com.example.ecommerce.model.partner.PartnerInfo;
import com.example.ecommerce.service.partner.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerActivity implements PartnerService {

    @Autowired
    private PartnerDAOImpl partnerDAO;

    public String addPartnerData(PartnerInfo partnerInfo) {

        return partnerDAO.savePartnerInfo(partnerInfo);
    }
}
