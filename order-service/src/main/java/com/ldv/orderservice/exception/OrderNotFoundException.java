package com.ldv.orderservice.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(Long orderId) {
        super("Order with ID " + orderId + " not found.");
    }
}
