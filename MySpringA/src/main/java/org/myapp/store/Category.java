package org.myapp.store;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryId = 101;
    private String categoryName = "Electronics";

    // Getters
    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
