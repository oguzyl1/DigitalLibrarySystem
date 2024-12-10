package com.kitaplik.library_service.exception;

public record ExceptionMessage(String timeStamp,
                               int statusCode,
                               String error,
                               String message,
                               String path) {
}
