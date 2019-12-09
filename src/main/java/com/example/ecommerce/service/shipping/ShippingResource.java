package com.example.ecommerce.service.shipping;

import com.example.ecommerce.service.shipping.representation.ShippingDetails;
import com.example.ecommerce.service.shipping.representation.response.ShippingDetailsResponse;
import com.example.ecommerce.service.shipping.workflow.ShippingActivity;
import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
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

@Controller("shippingService")
@Path("/shippingData")
public class ShippingResource {

    @Context
    private HttpHeaders headers;

    @OPTIONS
    @Path("/{trackingNumber}")
    @LocalPreflight
    public Response options(@PathParam("trackingNumber") String productID){
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
    private ShippingActivity shippingService;

    @POST
    public ResponseEntity<ShippingDetailsResponse> createShippingInfo(@RequestBody ShippingDetails shippingDetails) {
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
