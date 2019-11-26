package com.example.ecommerce.dal.order;

import com.example.ecommerce.model.order.Cart;
import com.example.ecommerce.model.order.SoldProduct;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class OrderDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    //@Transactional
    public String saveOrders(Cart cart) {
        Session session=sessionFactory.getCurrentSession();
        session.persist(cart);

        return cart.getCartId();
    }


    public List<SoldProduct> findItems(String orderId) {
        Session session=sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(Cart.class)
                .add(Restrictions.eq("cartId",orderId));

        List<Cart> items = (List<Cart>)criteria.list();

        List<SoldProduct> products=items.stream()
                .flatMap(cart -> cart.getItems().stream())
                .collect(Collectors.toList());

        return products;
    }
}
