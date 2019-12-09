package com.example.ecommerce.service.customer;

import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.representation.request.UserDetails;
import com.example.ecommerce.service.customer.representation.response.UserResponse;
import com.example.ecommerce.service.customer.workflow.CustomerActivity;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller("userService")
@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:3000"},
        allowCredentials = true,
        allowHeaders = {
                "'Accept': 'application/json'",
                "'Content-Type': 'application/json'"
        }
)
@Path("/users")
public class CustomerResource {

    @Context
    private HttpHeaders headers;

    @OPTIONS
    @Path("/{userId}")
    @LocalPreflight
    public Response options(@PathParam("userId") String productID){
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
    private CustomerActivity registerCustomer;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<UserResponse> addUsers(@RequestBody UserDetails userData) {

        UserResponse userResponse = registerCustomer.registerCustomer(userData.getUserData());
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GET
    @Path("/{userId}")
    public ResponseEntity<UserResponse> lookForUser(@PathParam("userId") String userId) {

        UserResponse userResponse=registerCustomer.searchCustomer(userId);
        return new ResponseEntity<>(userResponse,HttpStatus.ACCEPTED);
    }

    @PUT
    public ResponseEntity<UserResponse> updateUsers(@RequestBody UserDetails userData) {

        UserResponse userResponse = registerCustomer.modifyCustomerData(userData.getUserData());
        return new ResponseEntity<>(userResponse, HttpStatus.ACCEPTED);
    }
}
