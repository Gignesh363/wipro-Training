package com.wipro.assiessment19;

import com.wipro.assiessment19.service.DeliveryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryServiceTest {

    @Test
    void testFallbackDeliveryStatus() {
        DeliveryService service = new DeliveryService();
        String result = service.fallbackDeliveryStatus(new RuntimeException("Test error"));
        assertTrue(result.contains("unavailable"));
    }
}
