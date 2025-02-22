package com.ldv.productservice.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(Long orderId) {
        super("Product with ID " + orderId + " not found.");
    }
}
