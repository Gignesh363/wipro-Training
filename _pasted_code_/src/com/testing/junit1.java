package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

// Class with factorial logic
class MathUtils {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative numbers not allowed");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

// Test class using JUnit
public class junit1 {

    @Test
    public void testFactorialValidInputs() {
        assertEquals(1, MathUtils.factorial(0));
        assertEquals(1, MathUtils.factorial(1));
        assertEquals(6, MathUtils.factorial(3));
        assertEquals(120, MathUtils.factorial(5));
    }

    @Test
    public void testFactorialNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MathUtils.factorial(-1);
        });

        assertEquals("Negative numbers not allowed", exception.getMessage());
    }
}
