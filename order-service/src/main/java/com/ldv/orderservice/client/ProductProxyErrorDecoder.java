package com.ldv.orderservice.client;

import com.ldv.orderservice.exception.BadRequestException;
import com.ldv.orderservice.exception.InternalServerException;
import com.ldv.orderservice.exception.ResourceNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductProxyErrorDecoder implements ErrorDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductProxyErrorDecoder.class);

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        LOGGER.error("Feign error: {} - {}", response.status(), response.reason());

        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad request: Check your request parameters.");
            case 404:
                return new ResourceNotFoundException("Product not found.");
            case 500:
                return new InternalServerException("Internal server error. Please try again later.");
            default:
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}