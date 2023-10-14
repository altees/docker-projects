package com.altess.AccountMS.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Table("account")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("userId")
    private String userId;
    @Column("firstName")
    private String firstName;
    @Column("lastName")
    private String lastName;
    @Column("email")
    private String email;
    @Column("password")
    private String password;
    @Column("loginAttempt")
    private int loginAttempt;
    @Column("subscribed")
    private boolean subscribed;
    @Column("isActive")
    private boolean isActive;
    @Column("passwordResetOn")
    private String passwordResetOn;
    @Column("signOutOn")
    private String signOutOn;
    @Column("inActivatedOn")
    private String inActivatedOn;
    @Column("dateOfBirth")
    private String dateOfBirth;
    @Column("monthOfBirth")
    private String monthOfBirth;
    @Column("storeId")
    private String storeId;
    @Column("shoppingFor")
    private String shoppingFor;
    @Column("aboutUs")
    private String aboutUs;
    @Column("accountType")
    private String accountType;
    @Column("groupType")
    private String groupType;
    @Column("updatedDate")
    private LocalDateTime updatedDate;
    @Column("createdDate")
    private LocalDateTime createdDate;
    @Column("isFreshAddressValidated")
    private boolean isFreshAddressValidated;
    @Column("organizationUnitId")
    private String organizationUnitId;

    public User() {
        // Default constructor
    }

    public User(String firstName, String lastName, String email,String password, int loginAttempt,
                boolean subscribed, boolean isActive, String passwordResetOn, String signOutOn,
                String inActivatedOn, String dateOfBirth, String monthOfBirth, String storeId,
                String shoppingFor, String aboutUs, String accountType, String groupType,
                LocalDateTime updatedDate, LocalDateTime createdDate, boolean isFreshAddressValidated,
                String organizationUnitId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
        this.loginAttempt = loginAttempt;
        this.subscribed = subscribed;
        this.isActive = isActive;
        this.passwordResetOn = passwordResetOn;
        this.signOutOn = signOutOn;
        this.inActivatedOn = inActivatedOn;
        this.dateOfBirth = dateOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.storeId = storeId;
        this.shoppingFor = shoppingFor;
        this.aboutUs = aboutUs;
        this.accountType = accountType;
        this.groupType = groupType;
        this.updatedDate = updatedDate;
        this.createdDate = createdDate;
        this.isFreshAddressValidated = isFreshAddressValidated;
        this.organizationUnitId = organizationUnitId;
    }

}
