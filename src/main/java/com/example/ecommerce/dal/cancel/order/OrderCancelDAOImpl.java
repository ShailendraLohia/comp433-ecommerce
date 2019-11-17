package com.example.ecommerce.dal.cancel.order;


import com.example.ecommerce.model.cancel.order.OrderCancel;
import com.example.ecommerce.model.cancel.order.ReturnItems;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class OrderCancelDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public String saveReturnItems(OrderCancel orderCancel){
        Session session=sessionFactory.getCurrentSession();
        session.persist(orderCancel);

        return orderCancel.getCancelOrderId();
    }

    public Set<ReturnItems> findReturnItems(String returnOrderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(OrderCancel.class)
                .add(Restrictions.eq("cancelOrderId", returnOrderId));

        List<OrderCancel> items = (List<OrderCancel>)criteria.list();

        Set<ReturnItems> returnItems = items.stream()
                .flatMap(OrderCancel -> OrderCancel.getReturnItems().stream())
                .collect(Collectors.toSet());

        return returnItems;
    }
}
