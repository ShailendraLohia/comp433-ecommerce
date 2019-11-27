package com.example.ecommerce.service.order;

import com.example.ecommerce.service.order.representation.request.OrderDetails;
import com.example.ecommerce.service.order.representation.response.ItemsDetail;
import com.example.ecommerce.service.order.representation.response.OrderDetailsResponse;

public interface OrderService {
    public OrderDetailsResponse addNewOrder(OrderDetails orderDetails) throws Exception;
    public ItemsDetail getAllItems(String orderId);
}
