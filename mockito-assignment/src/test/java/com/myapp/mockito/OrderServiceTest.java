package com.myapp.mockito;

import com.myapp.mockito.service.OrderService;
import com.myapp.mockito.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void testPlaceOrder_VerifyPaymentServiceCalledOnce() {
        // Mock PaymentService
        PaymentService mockPaymentService = Mockito.mock(PaymentService.class);

        // Define mock behavior
        when(mockPaymentService.processPayment(100.0)).thenReturn("SUCCESS");

        // Inject mock into OrderService
        OrderService orderService = new OrderService(mockPaymentService);

        // Call placeOrder
        String result = orderService.placeOrder(100.0);

        // Assert
        assertEquals("Order Placed", result);

        // Verify processPayment() called exactly once
        verify(mockPaymentService, times(1)).processPayment(100.0);
    }
}
