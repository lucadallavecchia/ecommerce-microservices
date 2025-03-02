package com.ldv.productservice.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
