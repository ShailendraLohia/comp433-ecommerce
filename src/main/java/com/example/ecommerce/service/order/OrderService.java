package com.example.ecommerce.service.order;

import com.example.ecommerce.service.order.representation.request.OrderDetails;
import com.example.ecommerce.service.order.representation.response.ItemsDetail;

public interface OrderService {
    public String addNewOrder(OrderDetails orderDetails) throws Exception;
    public ItemsDetail getAllItems(String orderId);
}
