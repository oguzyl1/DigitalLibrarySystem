package com.kitaplik.book_service.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class TheBookAlreadyExistException extends RuntimeException {
    public TheBookAlreadyExistException(String s) {
        super(s);
    }
}
