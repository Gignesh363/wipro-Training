package com.springaop.shoppingapp;

import com.springaop.shoppingapp.service.ShoppingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop-config.xml");
        ShoppingService shoppingService = context.getBean("shoppingService", ShoppingService.class);

        System.out.println("----- Flow Start -----");
        shoppingService.addToCart("iPhone");
        shoppingService.makePayment(79999);
        shoppingService.placeOrder();
        System.out.println("----- Flow End -----");
    }
}
