package com.example.ecommerce.service.order;

import com.example.ecommerce.dal.customer.CustomerDAOImpl;
import com.example.ecommerce.dal.order.OrderDAOImpl;
import com.example.ecommerce.exceptions.CartEmptyException;
import com.example.ecommerce.exceptions.Error;
import com.example.ecommerce.exceptions.OrderNotFoundException;
import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.model.order.SoldProduct;
import com.example.ecommerce.representation.request.order.OrderDetails;
import com.example.ecommerce.representation.response.ItemsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl {
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
        user=customerDAO.findCustomer(user);

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
