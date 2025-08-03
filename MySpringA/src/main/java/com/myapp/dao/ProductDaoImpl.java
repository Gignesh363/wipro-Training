package com.myapp.dao;

import com.myapp.bean.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product getProductDetails(int product_code) {
        String sql = "SELECT * FROM product WHERE product_code=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{product_code}, new BeanPropertyRowMapper<>(Product.class));
    }
}
