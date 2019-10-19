package com.example.ecommerce.controller;

import com.example.ecommerce.service.workflow.customer.CustomerActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller("playerService")
@Path("course")

public class HelloController {

    @Autowired
    private CustomerActivity registerCustomer;

    @GET
    public String sayHello() {
        return "say Hello!";
    }

//    public ResponseEntity<String> sayHelloDear() {
//        return new ResponseEntity<>("Hello", HttpStatus.OK);
//    }



}
