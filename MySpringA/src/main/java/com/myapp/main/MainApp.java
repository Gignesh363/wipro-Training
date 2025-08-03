package com.myapp.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.bean.Product;
import com.myapp.service.BillingException;
import com.myapp.service.ProductService;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new ClassPathXmlApplicationContext("product-config.xml");
        ProductService productService = (ProductService) context.getBean("productService");

        while (true) {
            System.out.println("1. Generate Bill by entering code and quantity");
            System.out.println("2. Exit");
            int option = scanner.nextInt();

            if (option == 2) {
                break;
            } else if (option == 1) {
                int code = 0;
                int quantity = 0;

                while (true) {
                    try {
                        System.out.println("Enter product_code");
                        code = scanner.nextInt();
                        if (!productService.validateProductCode(code)) {
                            throw new BillingException("Invalid product_code, it should be >0 and 4 digit +ve number");
                        }
                        break;
                    } catch (BillingException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("Enter quantity");
                        quantity = scanner.nextInt();
                        if (!productService.validateQuantity(quantity)) {
                            throw new BillingException("Invalid quantity, it should be >0");
                        }
                        break;
                    } catch (BillingException e) {
                        System.out.println(e.getMessage());
                    }
                }

                Product product = productService.getProductDetails(code);
                System.out.println("Product Name: " + product.getProduct_name());
                System.out.println("Product Category: " + product.getProduct_category());
                System.out.println("Product Description: " + product.getProduct_description());
                System.out.println("Product Price(Rs): " + product.getProduct_price());
                System.out.println("Quantity: " + quantity);
                System.out.println("Total Bill Amount: Rs." + productService.calculatePrice(quantity, product.getProduct_price()));
            } else {
                System.out.println("Enter option 1 to 2 only");
            }
        }

        scanner.close();
    }
}
