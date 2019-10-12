package com.example.ecommerce.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(){}
    public OrderNotFoundException(String message) {super(message);}
}
