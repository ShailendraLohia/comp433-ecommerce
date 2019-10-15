package com.example.ecommerce.service.customer;

import com.example.ecommerce.service.representation.request.customer.UserDetails;
import com.example.ecommerce.service.representation.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Controller("userService")
@Path("/users")
public class CustomerResource {

    @Autowired
    private RegisterCustomerImpl registerCustomer;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public ResponseEntity<UserResponse> addUsers(@RequestBody UserDetails userData) {
        String response = registerCustomer.registerCustomer(userData.getUserData());
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(response);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
}
