package com.ldv.orderservice.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
