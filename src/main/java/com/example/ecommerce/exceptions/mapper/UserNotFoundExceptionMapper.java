package com.example.ecommerce.exceptions.mapper;

import com.example.ecommerce.exceptions.Error;
import com.example.ecommerce.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;


@Provider
public class UserNotFoundExceptionMapper implements ExceptionMapper<UserNotFoundException> {

    @Override
    public Response toResponse(UserNotFoundException ex) {
        Error error=new Error(HttpStatus.NOT_FOUND,ex.getMessage(),new Date());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
