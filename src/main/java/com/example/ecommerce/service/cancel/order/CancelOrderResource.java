package com.example.ecommerce.service.cancel.order;

import com.example.ecommerce.exceptions.UserNotFoundException;
import com.example.ecommerce.service.cancel.order.representation.request.CancelOrderDetails;
import com.example.ecommerce.service.cancel.order.representation.response.CancelOrderResponse;
import com.example.ecommerce.service.cancel.order.workflow.CancelOrderActivity;
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

@Controller("cancelOrderService")
@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:3000"},
        allowCredentials = true,
        allowHeaders = {
                "'Accept': 'application/json'",
                "'Content-Type': 'application/json'"
        }
)
@Path("/cancelOrders")
public class CancelOrderResource {

    @Context
    private HttpHeaders headers;

    @OPTIONS
    @Path("/{cancelOrderId}")
    @LocalPreflight
    public Response options(@PathParam("cancelOrderId") String productID){
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
    private CancelOrderActivity cancelOrderService;

    @POST
    public ResponseEntity<CancelOrderResponse> cancelOrder(@RequestBody CancelOrderDetails cancelOrderDetails) throws Exception{
        CancelOrderResponse response=null;
        try {
            response = cancelOrderService.cancelOrder(cancelOrderDetails);

        }catch (UserNotFoundException ex) {
            throw new UserNotFoundException(ex.getMessage());
        }catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GET
    @Path("/{cancelOrderId}")
    public ResponseEntity<String> getListOfItems(@PathParam("cancelOrderId") String cancelOrderId) {
        String response=cancelOrderService.returnAllItems(cancelOrderId);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
