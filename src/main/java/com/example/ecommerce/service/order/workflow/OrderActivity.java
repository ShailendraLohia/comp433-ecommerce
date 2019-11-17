package com.example.ecommerce.service.order.workflow;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.dal.order.OrderDAOImpl;
import com.example.ecommerce.exceptions.CartEmptyException;
import com.example.ecommerce.exceptions.OrderNotFoundException;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.model.customer.CustomerManager;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.model.order.OrderManager;
import com.example.ecommerce.model.order.SoldProduct;
import com.example.ecommerce.service.order.OrderService;
import com.example.ecommerce.service.order.representation.request.OrderDetails;
import com.example.ecommerce.service.order.representation.response.ItemsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderActivity implements OrderService {
    @Autowired
    private OrderManager orderManager;
    private CustomerManager customerManager;

    public String addNewOrder(OrderDetails orderDetails) throws Exception{
        //Cart empty check
        List<SoldProduct> products=orderDetails.getOrderDetails().getItems();
        if(products.size()==0)
            throw new CartEmptyException("Cart cannot be empty");

        //User not registered check
        User user=orderDetails.getOrderDetails().getUser();
        Optional<User> user_1=customerManager.findCustomer(user.getUserId());

        if(!user_1.isPresent()) { // User not registered. Don't accept order.
            throw new UserNotFoundException("User not registered,Please get added into system");
            //https://www.journaldev.com/2651/spring-mvc-exception-handling-controlleradvice-exceptionhandler-handlerexceptionresolver
        }
        
        return orderManager.saveOrders(orderDetails.getOrderDetails());
    }

    public ItemsDetail getAllItems(String orderId) {
        List<SoldProduct> productSold= orderManager.findItems(orderId);
        if(productSold.size()==0) {
            throw new OrderNotFoundException("Requested cart not found");
        }
        ItemsDetail itemsDetail = new ItemsDetail();
        itemsDetail.setCartId(orderId);
        itemsDetail.setItemsSold(productSold);

        return itemsDetail;
    }
}