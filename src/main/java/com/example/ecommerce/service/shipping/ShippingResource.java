package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.representation.request.shipping.ShippingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Controller("shippingService")
@Path("/shippingData")
public class ShippingResource {

    @Autowired
    private ShippingServiceImpl shippingService;

    @POST
    public ResponseEntity<String> createShippingInfo(@RequestBody ShippingDetails shippingDetails) {
        return new ResponseEntity<>(shippingService.createShippingInformation(shippingDetails),
                HttpStatus.CREATED);
    }
}
