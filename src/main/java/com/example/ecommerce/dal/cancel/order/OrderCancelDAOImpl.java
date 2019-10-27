package com.example.ecommerce.dal.cancel.order;


import com.example.ecommerce.model.cancel.order.OrderCancel;
import com.example.ecommerce.model.cancel.order.ReturnItems;
import com.example.ecommerce.model.order.SoldProduct;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class OrderCancelDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    public String saveReturnItems(OrderCancel orderCancel){
        Set<ReturnItems> itemData = new HashSet<>();

        String cancelOrderId = String.valueOf(Instant.now().toEpochMilli());
        orderCancel.setCancelOrderId(cancelOrderId);

        if(orderCancel.getReturnItems().size() > 0) {
            for(ReturnItems items:orderCancel.getReturnItems()) {
                items.setOrderCancel(orderCancel);
                itemData.add(items);
            }
        }

        orderCancel.setReturnItems(itemData);
        Session session=sessionFactory.getCurrentSession();
        session.persist(orderCancel);

        return cancelOrderId;
    }

    public List<ReturnItems> findReturnItems(String returnOrderId) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(OrderCancel.class)
                .add(Restrictions.eq("cancelOrderId", returnOrderId));

        List<OrderCancel> items = (List<OrderCancel>)criteria.list();

        List<ReturnItems> returnItems = items.stream()
                .flatMap(OrderCancel -> OrderCancel.getReturnItems().stream())
                .collect(Collectors.toList());

        return returnItems;
    }
}
