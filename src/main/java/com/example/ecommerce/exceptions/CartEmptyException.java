package com.example.ecommerce.exceptions;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException() {

    }
    public CartEmptyException(String message) {
        super(message);
    }
}
