package com.example.ecommerce.model.order;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.dal.order.OrderDAOImpl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private OrderDAOImpl orderDAO = new OrderDAOImpl();
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public String saveOrders(Cart cart) {
        List<SoldProduct> itemData = new ArrayList<>();

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

        return orderDAO.saveOrders(cart);
    }


    public List<SoldProduct> findItems(String orderId) {
        return orderDAO.findItems(orderId);
    }
}
