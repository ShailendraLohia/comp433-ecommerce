package com.example.ecommerce.service.cancel.order.workflow;

import com.example.ecommerce.dal.cancel.order.OrderCancelDAOImpl;
import com.example.ecommerce.exceptions.OrderNotFoundException;
import com.example.ecommerce.exceptions.ReturnListEmptyException;
import com.example.ecommerce.model.cancel.order.OrderCancel;
import com.example.ecommerce.model.cancel.order.ReturnItems;
import com.example.ecommerce.service.cancel.order.CancelOrderService;
import com.example.ecommerce.service.cancel.order.representation.request.CancelOrderDetails;
import com.example.ecommerce.service.cancel.order.representation.response.CancelOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CancelOrderActivity implements CancelOrderService {

    @Autowired
    private OrderCancelDAOImpl orderCancelDAO;

    public String cancelOrder(CancelOrderDetails cancelOrderDetails) throws Exception {
        OrderCancel orderCancel = cancelOrderDetails.getOrderCancel();
        //Cart empty check
        Set<ReturnItems> items = orderCancel.getReturnItems();
        if(items.size() == 0)
            throw new ReturnListEmptyException("Return List cannot be empty");
        return orderCancelDAO.saveReturnItems(orderCancel);
    }

    public CancelOrderResponse returnAllItems(String orderCancelId) {
        Set<ReturnItems> orderCancelItems = orderCancelDAO.findReturnItems(orderCancelId);
        if(orderCancelItems.size() == 0) {
            throw new OrderNotFoundException("Requested cart not found");
        }
        CancelOrderResponse cancelOrderResponse = new CancelOrderResponse();
        cancelOrderResponse.setReturnItems(orderCancelItems);
        return cancelOrderResponse;
    }
}
