package com.springaop.shoppingapp.service;

public class ShoppingService {
    public void addToCart(String item) {
        System.out.println("Adding to cart: " + item);
    }

    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " done successfully.");
    }

    public void placeOrder() {
        System.out.println("Order has been placed.");
    }
}
