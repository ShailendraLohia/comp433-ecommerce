package com.example.ecommerce.service.order;

import com.example.ecommerce.representation.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Controller("orderService")
@Path("/orders")
public class OrderResource {
    @Autowired
    private OrderServiceImpl orderService;
    @POST
    public ResponseEntity<String> placeNewOrder(@RequestBody OrderDetails orderDetails) {
        String response=orderService.addNewOrder(orderDetails);

        return new ResponseEntity<>(response, HttpStatus.CREATED);


    }
}
