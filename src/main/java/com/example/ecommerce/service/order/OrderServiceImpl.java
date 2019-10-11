package com.example.ecommerce.service.order;

import com.example.ecommerce.dal.order.OrderDAOImpl;
import com.example.ecommerce.model.order.SoldProduct;
import com.example.ecommerce.representation.request.order.OrderDetails;
import com.example.ecommerce.representation.response.ItemsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    @Autowired
    private OrderDAOImpl orderDAO;

    public String addNewOrder(OrderDetails orderDetails) {
        orderDAO.saveOrders(orderDetails.getOrderDetails());

        return "cart added";

    }

    public ItemsDetail getAllItems(String orderId) {
        List<SoldProduct> productSold= orderDAO.findItems(orderId);
        ItemsDetail itemsDetail=new ItemsDetail();
        itemsDetail.setCartId(orderId);
        itemsDetail.setItemsSold(productSold);

        return itemsDetail;
    }
}
