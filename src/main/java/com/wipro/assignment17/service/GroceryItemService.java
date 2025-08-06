package com.wipro.assignment17.service;

import com.wipro.assignment17.entity.GroceryItem;
import com.wipro.assignment17.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public GroceryItem addItem(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem item) {
        if (repository.existsById(id)) {
            item.setId(id);
            return repository.save(item);
        }
        return null;
    }

    public boolean deleteItem(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
