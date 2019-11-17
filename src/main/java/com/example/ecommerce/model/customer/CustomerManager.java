package com.example.ecommerce.model.customer;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.model.payment.CardInfo;

import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CustomerManager {

    private CustomerDAOImpl dao = new CustomerDAOImpl();

    public Optional<User> findCustomer(String userId) {

        return dao.findCustomer(userId);
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

        return dao.addCustomer(user);
    }

    public Optional<User> updateCustomerData(User user) {

        return dao.updateCustomerData(user);

    }
}
