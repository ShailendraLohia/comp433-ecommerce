package com.example.ecommerce.exceptions;

public class ReturnListEmptyException extends RuntimeException {
    public ReturnListEmptyException(){}
    public ReturnListEmptyException(String message) {super(message);}
}
