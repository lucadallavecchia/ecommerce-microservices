package com.ldv.productservice.config;

import ch.qos.logback.classic.Logger;
import com.ldv.productservice.exception.ProductNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        for (ConstraintViolation<?> violation : violations) {
            String fieldName = violation.getPropertyPath().toString(); // Ottiene il nome del campo
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }

        return errors;
    }


    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleProductNotFoundException(ProductNotFoundException ex) {
        return error(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleIllegalArgumentException(IllegalArgumentException ex) {
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
