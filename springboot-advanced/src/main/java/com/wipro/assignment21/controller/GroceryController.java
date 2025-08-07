package com.wipro.assignment21.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroceryController {

    @GetMapping("/grocery/public")
    public String welcome() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/grocery/items")
    public String items() {
        return "List of grocery items";
    }

    @GetMapping("/grocery/orders")
    public String orders() {
        return "List of grocery orders (Admin only)";
    }
}
