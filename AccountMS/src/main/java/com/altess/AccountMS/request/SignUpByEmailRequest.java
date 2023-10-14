package com.altess.AccountMS.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Optional;

@Valid
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpByEmailRequest extends BaseRequest {
    @NotBlank(message = "First Name is required")
    @Pattern(regexp = "^[a-zA-Z\\-\\s]+$", message = "Invalid First Name")
    @Size(max = 40, message = "First Name length should not exceed 40 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    @Pattern(regexp = "^[a-zA-Z\\-\\s]+$", message = "Invalid Last Name")
    @Size(max = 40, message = "Last Name length should not exceed 40 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 40, message = "Email length should not exceed 40 characters")
    private String email;

    @NotBlank(message = "Mobile Number is required")
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid Mobile Number")
    private String mobileNumber;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$", message = "Invalid Password")
    private String password;

    @NotNull(message = "Subscribed is required")
    private Boolean subscribed;

    @NotNull(message = "SMS Subscribed is required")
    private Boolean smsSubscribed;

    @NotBlank(message = "Postal Code is required")
    private String postalCode;

    // Getters and setters
}
