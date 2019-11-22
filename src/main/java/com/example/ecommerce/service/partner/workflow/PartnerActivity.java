package com.example.ecommerce.service.partner.workflow;

import com.example.ecommerce.dal.partner.PartnerDAOImpl;
import com.example.ecommerce.model.Link;
import com.example.ecommerce.model.partner.PartnerInfo;
import com.example.ecommerce.model.partner.PartnerManager;
import com.example.ecommerce.service.partner.PartnerService;
import com.example.ecommerce.service.partner.representation.PartnerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerActivity implements PartnerService {

    //@Autowired
    //private PartnerDAOImpl partnerDAO;
    private PartnerManager partnerManager = new PartnerManager();

    public String addPartnerData(PartnerInfo partnerInfo) {

        return partnerManager.savePartnerInfo(partnerInfo);
    }

    private void setLinks(PartnerDetails response) {
        Link buy = new Link("buy", "http://");
        response.setLinks(buy);
    }
}
