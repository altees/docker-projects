package com.alt.user.domain;

import com.alt.user.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String city;
    private String profileImageURL;
    private UserType userType;
    private String professionalDescription;    //applicable only for professionals
    private String professionalSpecialization;      // professionals degree,course,certification
    private boolean isActive;
}
