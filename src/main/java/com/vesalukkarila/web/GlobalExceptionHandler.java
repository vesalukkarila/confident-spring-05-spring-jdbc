package com.vesalukkarila.web;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//applies to both @Controller and @RestController and writes JSON/XML to response body
@RestControllerAdvice
public class GlobalExceptionHandler {

    // fires when @Valid validation against DTO fails
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleGethodArgumentNotValid(MethodArgumentNotValidException exception) {
        return "That was not right: " + exception.getMessage();
    }

    //fires when request parameter validation error occurs
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolation(ConstraintViolationException exception) {
        return "That was not quite right: " + exception.getMessage();
    }
}
