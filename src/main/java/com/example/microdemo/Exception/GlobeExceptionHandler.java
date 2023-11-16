package com.example.microdemo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@RestControllerAdvice
public class GlobeExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> myExceptionHandler(UserNotFoundException ufe, WebRequest wr){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ufe.getMessage(),wr.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> validationHandler(MethodArgumentNotValidException methodArgumentNotValidException, WebRequest wr){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Total Error: "+ methodArgumentNotValidException.getErrorCount() +" Fist Error - "+ Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage(),wr.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
