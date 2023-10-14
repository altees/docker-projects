package com.altess.AccountMS.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PasswordHasher {
    private static final int SALT_LENGTH = 16; // Length of the salt in bytes
    private static final int HASH_LENGTH = 64; // Length of the hashed password in bytes
    private static final int ITERATIONS = 10000; // Number of iterations for PBKDF2

    // Generate a salt for password hashing
    public static String generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash a password using PBKDF2 with a generated salt
    public static String hashPassword(String password, String salt) {
        try {
            KeySpec keySpec = new PBEKeySpec(password.toCharArray(), Base64.getDecoder().decode(salt), ITERATIONS, HASH_LENGTH * 8);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] hash = secretKeyFactory.generateSecret(keySpec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error hashing password: " + e.getMessage());
        }
    }

    // Verify a password against a hashed password and its salt
    public static boolean verifyPassword(String providedPassword, String salt, String hashedPassword) {
        String newHash = hashPassword(providedPassword, salt);
        return newHash.equals(hashedPassword);
    }
}
