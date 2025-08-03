package com.myapp.dao;

import com.myapp.bean.Product;

public interface ProductDao {
    Product getProductDetails(int product_code);
}
