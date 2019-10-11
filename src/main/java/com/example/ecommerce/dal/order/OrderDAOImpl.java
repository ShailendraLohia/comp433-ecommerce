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

@Repository
@Transactional
public class OrderDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    //@Transactional
    public String saveOrders(Cart cart) {
        List<SoldProduct> itemData=new ArrayList<>();

        String cartId=String.valueOf(Instant.now().toEpochMilli());
        cart.setCartId(cartId);

        if(cart.getItems().size()>0) {
            for(SoldProduct items:cart.getItems()) {
                items.setCart(cart);
                itemData.add(items);
            }
        }
        cart.setItems(itemData);
        cart.setUser(cart.getUser());
        Session session=sessionFactory.getCurrentSession();
        session.persist(cart);

        return cartId;
    }


    public List<SoldProduct> findItems(String orderId) {
        Session session=sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(Cart.class)
                .add(Restrictions.eq("cartId",orderId));

        List<Cart> items = (List<Cart>)criteria.list();

        List<SoldProduct> products=new ArrayList<>();

        for(Cart cart: items) {
            products=cart.getItems();
        }
        return products;

    }
}
