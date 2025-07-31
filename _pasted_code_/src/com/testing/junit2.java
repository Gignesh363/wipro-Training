package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class junit2 {

    // Method to reverse a string
    public static String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        return new StringBuilder(input).reverse().toString();
    }

    // JUnit test methods
    @Test
    public void testReverseRegularString() {
        assertEquals("olleh", reverse("hello"));
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", reverse(""));
    }

    @Test
    public void testReverseNullInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            reverse(null);
        });
        assertEquals("Input cannot be null", exception.getMessage());
    }
}
