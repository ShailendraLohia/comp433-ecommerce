package com.example.ecommerce.model.cancel.order;

import com.example.ecommerce.dal.cancel.order.OrderCancelDAOImpl;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class CancelOrderManager {

    private OrderCancelDAOImpl orderCancelDAO = new OrderCancelDAOImpl();

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

        return orderCancelDAO.saveReturnItems(orderCancel);
    }

    public Set<ReturnItems> findReturnItems(String returnOrderId) {
        return orderCancelDAO.findReturnItems(returnOrderId);
    }
}
