package com.mydemo.purchase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("purchase-config.xml");
        Purchase purchase = (Purchase) context.getBean("purchase");
        purchase.displayPurchaseDetails();
    }
}
