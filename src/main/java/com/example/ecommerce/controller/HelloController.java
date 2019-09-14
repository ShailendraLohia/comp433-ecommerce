package com.example.ecommerce.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller("playerService")
@Path("course")

public class HelloController {

    @GET
//    public String sayHello() {
//        return "Hello";
//    }

    public ResponseEntity<String> sayHelloDear() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }


}
