package com.example.ecommerce.dao.customer;

import com.example.ecommerce.model.CardInfo;
import com.example.ecommerce.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Repository
public class DAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public String findCustomer() {
        return "customer found!";
    }

    @Transactional
    public String addCustomer(User user) {

        Set<CardInfo> cardData=new HashSet<>();
        //Generate Primary Key for customer
        String userId=String.valueOf(Instant.now().toEpochMilli());
        user.setUserId(userId); //Set Primary key
        if(user.getPaymentDetails().size()>0) {
            for(CardInfo cardInfo:user.getPaymentDetails()) {
                cardInfo.setUser(user);
                cardData.add(cardInfo);
            }
        }
        user.setPaymentDetails(cardData);
        Session session=sessionFactory.getCurrentSession();
        session.persist(user);
        return userId;

    }

}
