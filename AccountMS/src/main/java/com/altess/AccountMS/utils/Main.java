package com.altess.AccountMS.utils;

public class Main {
    public static void main(String[] args) {
        String password = "Test@123";
        String salt = PasswordHasher.generateSalt();
        String hashedPassword = PasswordHasher.hashPassword(password, salt);

        System.out.println("Salt: " + salt);
        System.out.println("Hashed Password: " + hashedPassword);

        // To verify a password, provide the same salt and hashed password
        boolean isPasswordValid = PasswordHasher.verifyPassword(password, PasswordHasher.generateSalt(), hashedPassword);
        System.out.println("Is Password Valid: " + isPasswordValid);
    }
}
