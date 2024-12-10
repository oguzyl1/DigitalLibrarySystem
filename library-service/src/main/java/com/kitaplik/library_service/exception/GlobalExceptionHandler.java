package com.kitaplik.library_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<?> handle(LibraryNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handle(BookNotFoundException e){
        return new ResponseEntity<>(e.getExceptionMessage(), HttpStatus.resolve(e.getExceptionMessage().statusCode()));
    }

}
