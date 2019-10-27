package com.example.ecommerce.dal.shipping;

import com.example.ecommerce.model.shipping.ShippingStatus;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Optional<String> fetchShippingStatus(String trackingNumber) {

        Session session=sessionFactory.getCurrentSession();

        Criteria criteria=session.createCriteria(ShippingStatus.class)
                .add(Restrictions.eq("trackingNumber",trackingNumber));

        List<ShippingStatus> status=criteria.list();

        //String shippingStatus=status.get(0).getShippingStatus();
        return status.stream()
                .map(ShippingStatus::getShippingStatus)
                .findFirst();
//        return status.stream().map(shippingStatus -> shippingStatus.getShippingStatus())
//                .findFirst();
    }

    public Optional<String> modifyStatus(ShippingStatus shippingStatus) {


        shippingStatus.setShippingStatus(shippingStatus.getShippingStatus());

        Session session=sessionFactory.getCurrentSession();

        session.update(shippingStatus);

        return fetchShippingStatus(shippingStatus.getTrackingNumber());


    }
}
