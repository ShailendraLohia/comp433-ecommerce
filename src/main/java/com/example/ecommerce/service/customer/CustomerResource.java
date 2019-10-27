package com.example.ecommerce.service.customer;

import com.example.ecommerce.model.customer.User;
import com.example.ecommerce.service.customer.representation.request.UserDetails;
import com.example.ecommerce.service.customer.representation.response.UserResponse;
import com.example.ecommerce.service.customer.workflow.CustomerActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller("userService")
@Path("/users")
public class CustomerResource {

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
