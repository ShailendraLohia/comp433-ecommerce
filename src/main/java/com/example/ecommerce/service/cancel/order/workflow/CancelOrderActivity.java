package com.example.ecommerce.service.cancel.order.workflow;

import com.example.ecommerce.dal.cancel.order.OrderCancelDAOImpl;
import com.example.ecommerce.exceptions.OrderNotFoundException;
import com.example.ecommerce.exceptions.ReturnListEmptyException;
import com.example.ecommerce.model.cancel.order.OrderCancel;
import com.example.ecommerce.model.cancel.order.ReturnItems;
import com.example.ecommerce.service.cancel.order.CancelOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class CancelOrderActivity implements CancelOrderService {

    @Autowired
    private OrderCancelDAOImpl orderCancelDAO;

    public String addOrderCancel(OrderCancel orderCancel) {
        //Cart empty check
        Set<ReturnItems> items = orderCancel.getReturnItems();
        if(items.size() == 0)
            throw new ReturnListEmptyException("Return List cannot be empty");
        return orderCancelDAO.saveReturnItems(orderCancel);
    }

    public List<ReturnItems> findReturnItems(String orderCancelId) {
        List<ReturnItems> orderCancel = orderCancelDAO.findReturnItems(orderCancelId);
        if(orderCancel.size() == 0) {
            throw new OrderNotFoundException("Requested cart not found");
        }
        return orderCancel;
    }
}
