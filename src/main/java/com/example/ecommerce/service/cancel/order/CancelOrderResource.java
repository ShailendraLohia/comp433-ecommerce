package com.example.ecommerce.service.cancel.order;

import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.service.cancel.order.representation.request.CancelOrderDetails;
import com.example.ecommerce.service.cancel.order.representation.response.CancelOrderResponse;
import com.example.ecommerce.service.cancel.order.workflow.CancelOrderActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Controller("cancelOrderService")
@Path("/cancelOrders")
public class CancelOrderResource {

    @Autowired
    private CancelOrderActivity cancelOrderService;

    @POST
    public ResponseEntity<String> cancelOrder(@RequestBody CancelOrderDetails cancelOrderDetails) throws Exception{
        String response=null;
        try {
            response = cancelOrderService.cancelOrder(cancelOrderDetails);

        }catch (UserNotFoundException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }

    @GET
    @Path("/{cancelOrderId}")
    public ResponseEntity<CancelOrderResponse> getListofItems(@PathParam("cancelOrderId") String cancelOrderId) {
        CancelOrderResponse response=cancelOrderService.returnAllItems(cancelOrderId);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
