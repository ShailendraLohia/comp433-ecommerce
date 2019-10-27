package com.example.ecommerce.dal.customer;

import com.example.ecommerce.model.payment.CardInfo;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.representation.response.UserResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class CustomerDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public Optional<User> findCustomer(String userId) {
        Session session=sessionFactory.getCurrentSession();
        User user=(User)session.get(User.class,userId);

        return Optional.ofNullable(user);
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

    public Optional<User> updateCustomerData(User user) {
        Session session=sessionFactory.getCurrentSession();
        session.update(user);

        return findCustomer(user.getUserId());
    }

}
