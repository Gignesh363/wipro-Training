package com.myapp.service;

import com.myapp.bean.Product;

public interface ProductService {
    Product getProductDetails(int product_code);
    double calculatePrice(int quantity, double price);
    boolean validateProductCode(int product_code);
    boolean validateQuantity(int quantity);
}
