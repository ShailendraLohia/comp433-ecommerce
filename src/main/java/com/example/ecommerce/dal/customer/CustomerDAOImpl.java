package com.example.ecommerce.dal.customer;

import com.example.ecommerce.model.payment.CardInfo;
import com.example.ecommerce.model.customer.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class DAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public User findCustomer(User user) {

        String userId=user.getUserId();
        Session session=sessionFactory.getCurrentSession();
        user=(User)session.get(User.class,userId);

        return user;
    }


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
