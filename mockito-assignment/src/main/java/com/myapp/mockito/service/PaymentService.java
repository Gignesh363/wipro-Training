package com.myapp.mockito.service;

public class PaymentService {

    public String processPayment(double amount) {
        // Normally calls a payment gateway
        return "Processed " + amount;
    }
}
