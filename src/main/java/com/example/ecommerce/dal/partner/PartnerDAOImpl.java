package com.example.ecommerce.dal.partner;

import com.example.ecommerce.model.partner.PartnerInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Repository
@Transactional
public class PartnerDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public String savePartnerInfo(PartnerInfo partnerInfo) {
        Session session=sessionFactory.getCurrentSession();
        session.save(partnerInfo);

//        return partnerId;
        return partnerInfo.getPartnerId();
    }
}
