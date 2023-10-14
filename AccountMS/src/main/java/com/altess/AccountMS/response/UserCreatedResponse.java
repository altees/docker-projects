package com.altess.AccountMS.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedResponse extends BaseResponse{
    private String id;
    private String time;
    private int statusCode;
    private String message;
    private String token;
}
