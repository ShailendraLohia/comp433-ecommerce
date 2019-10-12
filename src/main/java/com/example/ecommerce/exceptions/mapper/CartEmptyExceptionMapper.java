package com.example.ecommerce.exceptions.mapper;

import com.example.ecommerce.exceptions.CartEmptyException;
import com.example.ecommerce.exceptions.Error;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class CartEmptyExceptionMapper implements ExceptionMapper<CartEmptyException> {

    @Override
    public Response toResponse(CartEmptyException ex) {
        Error error=new Error(HttpStatus.BAD_REQUEST,ex.getMessage(),new Date());
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}
