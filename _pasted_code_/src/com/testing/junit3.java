package com.testing;





import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class junit3 {

    public static boolean validateLogin(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Username and password cannot be empty");
        }


        return username.equals("admin") && password.equals("password123");
    }


    @Test
    public void testValidCredentials() {
        assertTrue(validateLogin("admin", "password123"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(validateLogin("wrongUser", "password123"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(validateLogin("admin", "wrongPass"));
    }

    @Test
    public void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateLogin("", "password123");
        });
        assertEquals("Username and password cannot be empty", exception.getMessage());
    }

    @Test
    public void testEmptyPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateLogin("admin", "");
        });
        assertEquals("Username and password cannot be empty", exception.getMessage());
    }

    @Test
    public void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateLogin(null, "password123");
        });
        assertEquals("Username and password cannot be null", exception.getMessage());
    }

    @Test
    public void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            validateLogin("admin", null);
        });
        assertEquals("Username and password cannot be null", exception.getMessage());
    }
}
