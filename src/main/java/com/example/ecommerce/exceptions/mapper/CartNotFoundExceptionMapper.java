package com.example.ecommerce.exceptions.mapper;

import com.example.ecommerce.exceptions.CartNotFoundException;
import com.example.ecommerce.model.error.Error;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Date;

public class CartNotFoundExceptionMapper implements ExceptionMapper<CartNotFoundException> {
    @Override
    public Response toResponse(CartNotFoundException ex) {
        Error error=new Error(HttpStatus.NOT_FOUND,ex.getMessage(),new Date());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
