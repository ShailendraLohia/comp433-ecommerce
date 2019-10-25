package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.shipping.representation.ShippingDetails;
import com.example.ecommerce.service.shipping.workflow.ShippingActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;

@Controller("shippingService")
@Path("/shippingData")
public class ShippingResource {

    @Autowired
    private ShippingActivity shippingService;

    @POST
    public ResponseEntity<String> createShippingInfo(@RequestBody ShippingDetails shippingDetails) {
        return new ResponseEntity<>(shippingService.createShippingInformation(shippingDetails),
                HttpStatus.CREATED);
    }
    @GET
    @Path("/{trackingNumber}")
    public ResponseEntity<String> retrieveShippingStatus(@PathParam("trackingNumber") String trackingNumber) {

        return new ResponseEntity<>(shippingService.getShippingStatus(trackingNumber),
                HttpStatus.ACCEPTED);
    }
    @PUT
    public ResponseEntity<String> updateShippingStatus(@RequestBody ShippingDetails shippingDetails) {
        return new ResponseEntity<>(
                shippingService.updateShippingStatus(shippingDetails),HttpStatus.ACCEPTED);
    }

}
