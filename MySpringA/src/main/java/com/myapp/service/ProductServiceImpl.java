package com.myapp.service;

import com.myapp.bean.Product;
import com.myapp.dao.ProductDao;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product getProductDetails(int product_code) {
        return productDao.getProductDetails(product_code);
    }

    @Override
    public double calculatePrice(int quantity, double price) {
        return quantity * price;
    }

    @Override
    public boolean validateProductCode(int product_code) {
        return product_code > 0 && String.valueOf(product_code).length() == 4;
    }

    @Override
    public boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}
