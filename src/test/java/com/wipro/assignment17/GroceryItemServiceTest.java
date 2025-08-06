package com.wipro.assignment17;

import com.wipro.assignment17.entity.GroceryItem;
import com.wipro.assignment17.repository.GroceryItemRepository;
import com.wipro.assignment17.service.GroceryItemService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    public GroceryItemServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllItems() {
        GroceryItem item1 = new GroceryItem();
        item1.setName("Rice");
        GroceryItem item2 = new GroceryItem();
        item2.setName("Wheat");

        when(repository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<GroceryItem> items = service.getAllItems();
        assertEquals(2, items.size());
    }
}
