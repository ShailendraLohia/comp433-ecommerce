package com.example.ecommerce.dal.shipping;

import com.example.ecommerce.model.shipping.ShippingStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;

@Repository
@Transactional
public class ShippingDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

    public String saveShippingInfo(ShippingStatus shippingStatus) {

        //Generate Primary Key for customer
        String trackingNumber=(Instant.now().toEpochMilli())+
                shippingStatus.getCart().getCartId();

         //Set Shipping Status fields
        shippingStatus.setTrackingNumber(trackingNumber);
        shippingStatus.setCart(shippingStatus.getCart());
        shippingStatus.setShippedBy(shippingStatus.getShippedBy());
        shippingStatus.setShippingDate(LocalDate.now());
        shippingStatus.setArrivalDate(shippingStatus.getShippingDate().plusDays(2));
        shippingStatus.setShippingStatus(shippingStatus.getShippingStatus());

        Session session=sessionFactory.getCurrentSession();

        session.save(shippingStatus);

        return trackingNumber;

    }
}
