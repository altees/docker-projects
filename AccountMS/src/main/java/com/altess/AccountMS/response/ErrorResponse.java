package com.altess.AccountMS.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.Instant;

@JsonDeserialize
@Data
public class ErrorResponse extends BaseResponse{
    private Instant timestamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(Instant timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // Getters and setters
}
