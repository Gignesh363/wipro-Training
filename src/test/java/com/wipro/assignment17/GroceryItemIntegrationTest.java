package com.wipro.assignment17;

import com.wipro.assignment17.entity.GroceryItem;
import com.wipro.assignment17.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GroceryItemIntegrationTest {

    @Autowired
    private GroceryItemRepository repository;

    @Test
    void testSaveItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Sugar");
        item.setQuantity(5);
        item.setPrice(50);

        GroceryItem saved = repository.save(item);
        assertNotNull(saved.getId());
    }
}
