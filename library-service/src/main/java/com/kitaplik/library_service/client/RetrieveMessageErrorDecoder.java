package com.kitaplik.library_service.client;

import com.kitaplik.library_service.exception.BookNotFoundException;
import com.kitaplik.library_service.exception.ExceptionMessage;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {

        ExceptionMessage message = null;

        try (InputStream inputStream = response.body().asInputStream()) {

            message = new ExceptionMessage(
                    (String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(inputStream, StandardCharsets.UTF_8),
                    response.request().url());


        } catch (IOException exception) {
            return new Exception(exception.getMessage());
        }


        switch (response.status()){
            case 404:
                throw new BookNotFoundException(message);
            default:
                return errorDecoder.decode(s, response);
        }
    }
}
