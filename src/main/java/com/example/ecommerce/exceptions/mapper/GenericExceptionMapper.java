package com.example.ecommerce.exceptions.mapper;

import com.example.ecommerce.exceptions.Error;
import org.springframework.http.HttpStatus;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        Error error=new Error(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),new Date());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(error)
                .build();
    }
}
