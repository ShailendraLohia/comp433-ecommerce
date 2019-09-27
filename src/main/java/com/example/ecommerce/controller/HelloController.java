package com.example.ecommerce.controller;

import com.example.ecommerce.service.RegisterCustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller("playerService")
@Path("course")

public class HelloController {

    @Autowired
    private RegisterCustomerImpl registerCustomer;

    @GET
    public String sayHello() {
        return registerCustomer.registerCustomer();
    }

//    public ResponseEntity<String> sayHelloDear() {
//        return new ResponseEntity<>("Hello", HttpStatus.OK);
//    }



}
