package com.example.ecommerce;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller("playerService")
@Path("course")
public class HelloController {

    @GET
    public String sayHello() {
        return "Hello";
    }
}
