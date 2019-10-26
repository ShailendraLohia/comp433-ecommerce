package com.example.ecommerce.service.order.workflow;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.dal.order.OrderDAOImpl;
import com.example.ecommerce.exceptions.CartEmptyException;
import com.example.ecommerce.exceptions.OrderNotFoundException;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.model.order.SoldProduct;
import com.example.ecommerce.service.order.OrderService;
import com.example.ecommerce.service.order.representation.request.OrderDetails;
import com.example.ecommerce.service.order.representation.response.ItemsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderActivity implements OrderService {
    @Autowired
    private OrderDAOImpl orderDAO;
    @Autowired
    private CustomerDAOImpl customerDAO;

    public String addNewOrder(OrderDetails orderDetails) throws Exception{
        //Cart empty check
        List<SoldProduct> products=orderDetails.getOrderDetails().getItems();
        if(products.size()==0)
            throw new CartEmptyException("Cart cannot be empty");

        //User not registered check
        User user=orderDetails.getOrderDetails().getUser();
        user=customerDAO.findCustomer(user.getUserId());

        if(user==null) { // User not registered. Don't accept order.
            throw new UserNotFoundException("User not registered,Please get added into system");
            //https://www.journaldev.com/2651/spring-mvc-exception-handling-controlleradvice-exceptionhandler-handlerexceptionresolver
        }
        return orderDAO.saveOrders(orderDetails.getOrderDetails());

    }

    public ItemsDetail getAllItems(String orderId) {
        List<SoldProduct> productSold= orderDAO.findItems(orderId);
        if(productSold.size()==0) {
            throw new OrderNotFoundException("Requested cart not found");
        }
        ItemsDetail itemsDetail=new ItemsDetail();
        itemsDetail.setCartId(orderId);
        itemsDetail.setItemsSold(productSold);

        return itemsDetail;
    }

}
