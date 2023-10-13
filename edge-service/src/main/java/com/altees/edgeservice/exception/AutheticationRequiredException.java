package com.altees.edgeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AutheticationRequiredException extends ResponseStatusException {
    public AutheticationRequiredException(String message) {
        this(HttpStatus.UNAUTHORIZED, message);
    }
    private AutheticationRequiredException(HttpStatus httpStatus, String message) {
        super(httpStatus, message);
    }
}
