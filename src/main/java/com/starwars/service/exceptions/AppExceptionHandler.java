package com.starwars.service.exceptions;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

	
	@ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException exception, WebRequest request) {
        ApiError apiError = new ApiError("ValidationException",null,exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleValidationException(Exception exception, WebRequest request) {
        ApiError apiError = new ApiError("ValidationException",null,exception.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}
