package com.altees.edgeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadRequestException extends ResponseStatusException {
    public BadRequestException(String message) {
        this(HttpStatus.BAD_REQUEST, message);
    }

    private BadRequestException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}