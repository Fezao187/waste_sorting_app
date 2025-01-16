package com.enviro.assessment.grad001.katlegomaredi.excepttion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value={ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException exception){
        // 1. Create payload containing exception details
        ApiException apiException = new ApiException(
                exception.getMessage(),
                exception,
                HttpStatus.BAD_REQUEST
        );
        // 2. Return response entity
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
