package com.ldv.orderservice.config;

import ch.qos.logback.classic.Logger;
import com.ldv.orderservice.exception.OrderNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundError(NoHandlerFoundException ex) {
        return error("No endpoint found for the requested URL. Please check the API documentation and try again.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return errors;
    }

    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleOrderNotFoundException(OrderNotFoundException ex) {
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
