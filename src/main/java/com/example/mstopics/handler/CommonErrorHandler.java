package com.example.mstopics.handler;

import com.example.mstopics.exception.ResourceNotFoundException;
import com.example.mstopics.model.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class CommonErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiError> handleResourceNotFoundException(ResourceNotFoundException ex){
        return ResponseEntity.status(BAD_REQUEST).body(new ApiError(BAD_REQUEST.value(),ex.getMessage()));
    }
}
