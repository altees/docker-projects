package com.altees.edgeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class ForbiddenException extends ResponseStatusException {
    public ForbiddenException(String message) {
        this(HttpStatus.FORBIDDEN, message);
    }

    public ForbiddenException() {
        this(HttpStatus.FORBIDDEN, "Forbidden Request");
    }

    private ForbiddenException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}