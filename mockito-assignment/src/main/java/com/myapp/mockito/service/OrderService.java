package com.myapp.mockito.service;

import com.myapp.mockito.service.PaymentService;


public class OrderService {

    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String placeOrder(double amount) {
        String paymentResult = paymentService.processPayment(amount);
        if ("SUCCESS".equals(paymentResult)) {
            return "Order Placed";
        } else {
            return "Order Failed";
        }
    }
}
