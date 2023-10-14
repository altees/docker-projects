package com.altess.AccountMS.utils;

import com.altess.AccountMS.entity.User;
import com.altess.AccountMS.request.SignUpByEmailRequest;

import java.time.ZonedDateTime;
import java.util.UUID;

public class UserHelper {

    static final String EMPTY_STRING = "";


    public static User toUser(SignUpByEmailRequest request,String salt) {
        return new User( request.getFirstName(), request.getLastName(), request.getEmail(),request.getPassword()
                , 0, request.getSubscribed(), true, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING,
                EMPTY_STRING, EMPTY_STRING, "member", "customer", ZonedDateTime.now().toLocalDateTime(),
                ZonedDateTime.now().toLocalDateTime(), false, "organizationUnitId",salt);
    }
}
