package com.example.ecommerce.dao.order;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Items;
import com.example.ecommerce.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public String saveOrders(Cart cart) {
        List<Items> itemData=new ArrayList<>();

        String cartId=String.valueOf(Instant.now().toEpochMilli());
        cart.setCartId(cartId);

        if(cart.getItems().size()>0) {
            for(Items items:cart.getItems()) {
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
}
