package com.demo.playersaver.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return super.handleServletRequestBindingException(ex, headers, status, request);
    }

    @ExceptionHandler(NotFountException.class)
    public ResponseEntity<?> notFoundException(NotFountException exception){
        return new ResponseEntity<>("Message: " + exception.getMessage() + " (status): " + HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PlayerCountLimitExceededException.class)
    public ResponseEntity<?> playerCountLimitExceededException(PlayerCountLimitExceededException exception){
        return new ResponseEntity<>("Message: " + exception.getMessage() + " (status): " + HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }

}
