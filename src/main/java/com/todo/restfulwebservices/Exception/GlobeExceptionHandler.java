package com.todo.restfulwebservices.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Objects;

@RestControllerAdvice
public class GlobeExceptionHandler {

    // TODO: Refactor this method to return a ResponseEntity with status 404 and a body containing timestamp, error message, and description of the request
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> myExceptionHandler(UserNotFoundException ufe, WebRequest wr) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ufe.getMessage(), wr.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    /**
     * Handles MethodArgumentNotValidException by creating an ErrorDetails object with the current timestamp,
     * the total error count, the first error message, and the request description, and returning a
     * ResponseEntity with the ErrorDetails object and a NOT_FOUND status.
     *
     * @param methodArgumentNotValidException the exception to handle
     * @param wr the WebRequest object
     * @return a ResponseEntity with the ErrorDetails object and a NOT_FOUND status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> validationHandler(MethodArgumentNotValidException methodArgumentNotValidException, WebRequest wr){
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Total Error: "+ methodArgumentNotValidException.getErrorCount() +" Fist Error - "+ Objects.requireNonNull(methodArgumentNotValidException.getFieldError()).getDefaultMessage(),wr.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
