package com.example.ecommerce.service.order;

import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.service.order.representation.request.OrderDetails;
import com.example.ecommerce.service.order.representation.response.ItemsDetail;
import com.example.ecommerce.service.order.representation.response.OrderDetailsResponse;
import com.example.ecommerce.service.order.workflow.OrderActivity;
import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Controller("orderService")
@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:3000"},
        allowCredentials = true,
        allowHeaders = {
                "'Accept': 'application/json'",
                "'Content-Type': 'application/json'"
        }
)
@Path("/orders")
public class OrderResource {

    @Context
    private HttpHeaders headers;

    @OPTIONS
    @Path("/{orderID}")
    @LocalPreflight
    public Response options(@PathParam("orderID") String productID){
        String origin = headers.getOrigin();
        if("http://localhost:3000".equals(origin)) {
            return Response.ok()
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "GET")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:3000")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Accept")
                    .build();
        }
        else {
            return Response.ok().build();
        }
    }

    @OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options(){
        String origin = headers.getOrigin();
        if("http://localhost:3000".equals(origin)) {
            return Response.ok()
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:3000")
                    .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                    .build();
        }
        else {
            return Response.ok().build();
        }
    }

    @Autowired
    private OrderActivity orderService;

    @POST
    public ResponseEntity<OrderDetailsResponse> placeNewOrder(@RequestBody OrderDetails orderDetails) throws Exception{
        OrderDetailsResponse response=null;
        try {
            response = orderService.addNewOrder(orderDetails);

        }catch (UserNotFoundException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);

        //return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GET
    @Path("/{orderId}")
    public ResponseEntity<ItemsDetail> getListOfItems(@PathParam("orderId") String orderId) {
        ItemsDetail response=orderService.getAllItems(orderId);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
