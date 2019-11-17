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
        Session session=sessionFactory.getCurrentSession();
        session.save(shippingStatus);

        return shippingStatus.getTrackingNumber();
    }

    public Optional<String> fetchShippingStatus(String trackingNumber) {
        Session session=sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(ShippingStatus.class)
                .add(Restrictions.eq("trackingNumber",trackingNumber));
        List<ShippingStatus> status=criteria.list();

        return status.stream()
                .map(ShippingStatus::getShippingStatus)
                .findFirst();
    }

    public Optional<String> modifyStatus(ShippingStatus shippingStatus) {
        Session session=sessionFactory.getCurrentSession();
        session.update(shippingStatus);

        return fetchShippingStatus(shippingStatus.getTrackingNumber());
    }
}
