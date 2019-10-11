package com.example.ecommerce.service.order;

import com.example.ecommerce.dal.order.OrderDAOImpl;
import com.example.ecommerce.representation.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderDAOImpl orderDAO;

    public String addNewOrder(OrderDetails orderDetails) {
        orderDAO.saveOrders(orderDetails.getOrderDetails());

        return "cart added";

    }
}
