package com.ldv.productservice.config;

import ch.qos.logback.classic.Logger;
import com.ldv.productservice.exception.ProductNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleOrderNotFoundException(ProductNotFoundException ex) {
        return error(ex.getMessage());
    }

    /***
     * Generate a map with the message error.
     *
     * @param message
     * @return a map with a message attribute.
     */
    private Map<String, String> error(String message) {
        LOGGER.error(message);
        return Collections.singletonMap("message", message);
    }

}
