package com.example.ecommerce.model.cancel.order;

import com.example.ecommerce.dal.cancel.order.OrderCancelDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Component
public class CancelOrderManager {

    @Autowired
    private OrderCancelDAOImpl orderCancelDAO;// = new OrderCancelDAOImpl();

    public String saveReturnItems(OrderCancel orderCancel){


        return orderCancelDAO.saveReturnItems(orderCancel);
    }

    public Set<ReturnItems> findReturnItems(String returnOrderId) {
        return orderCancelDAO.findReturnItems(returnOrderId);
    }
}
