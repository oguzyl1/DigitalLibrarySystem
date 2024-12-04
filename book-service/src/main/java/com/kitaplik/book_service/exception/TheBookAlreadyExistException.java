package com.kitaplik.book_service.exception;

public class TheBookAlreadyExistException extends RuntimeException {
    public TheBookAlreadyExistException(String s) {
        super(s);
    }
}
