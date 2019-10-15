package com.example.ecommerce.service.order;

import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.service.representation.request.order.OrderDetails;
import com.example.ecommerce.service.representation.response.ItemsDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Controller("orderService")
@Path("/orders")
public class OrderResource {

    @Autowired
    private OrderServiceImpl orderService;

    @POST
    public ResponseEntity<String> placeNewOrder(@RequestBody OrderDetails orderDetails) throws Exception{
        String response=null;
        try {
            response = orderService.addNewOrder(orderDetails);

        }catch (UserNotFoundException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return new ResponseEntity<String>(response, HttpStatus.CREATED);
        //return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GET
    @Path("/{orderId}")
    public ResponseEntity<ItemsDetail> getListOfItems(@PathParam("orderId") String orderId) {
        ItemsDetail response=orderService.getAllItems(orderId);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }


}
