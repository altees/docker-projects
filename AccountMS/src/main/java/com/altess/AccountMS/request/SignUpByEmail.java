package com.altess.AccountMS.request;


import com.altess.AccountMS.constants.ErrorMessage;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@Valid
public class SignUpByEmail {
    @Pattern(regexp = "^[a-zA-Z\\-\\s]+$", message = ErrorMessage.ENTERED_INVALID_FIRST_NAME)
    private String firstName;
    @Pattern(regexp = "^[a-zA-Z\\-\\s]+$", message = ErrorMessage.ENTERED_INVALID_LAST_NAME)
    private String lastName;
    private String email;
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message ="Invalid mobile number")
    private String mobileNumber;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$",message = ErrorMessage.INVALID_PASSWORD)
    private String password;
    private boolean subscribed;
    private boolean smsSubscribed;
    private String postalCode;

    public SignUpByEmail() {
        // Default constructor
    }

    public SignUpByEmail(String firstName, String lastName, String email, String mobileNumber, String password, boolean subscribed, boolean smsSubscribed, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.subscribed = subscribed;
        this.smsSubscribed = smsSubscribed;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public boolean isSmsSubscribed() {
        return smsSubscribed;
    }

    public void setSmsSubscribed(boolean smsSubscribed) {
        this.smsSubscribed = smsSubscribed;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
