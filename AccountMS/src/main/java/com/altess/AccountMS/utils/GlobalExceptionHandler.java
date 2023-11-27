package com.altess.AccountMS.utils;

import com.altess.AccountMS.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<List<ErrorResponse>>> handleException(WebExchangeBindException e) {
        List<ErrorResponse> collect = e.getFieldErrors()
                .stream()
                .map(fieldError -> new ErrorResponse(Instant.now(), 400, fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return Mono.just(ResponseEntity.badRequest().body(collect));
    }
}