package com.example.ecommerce.service.cancel.order;

import com.example.ecommerce.service.cancel.order.representation.request.CancelOrderDetails;
import com.example.ecommerce.service.cancel.order.representation.response.CancelOrderResponse;

public interface CancelOrderService {
    public CancelOrderResponse cancelOrder(CancelOrderDetails cancelOrderDetails) throws Exception;
    public String returnAllItems(String cancelOrderId);
}
