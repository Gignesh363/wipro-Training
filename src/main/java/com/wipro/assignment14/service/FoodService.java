package com.wipro.assignment14.service;

import com.wipro.assignment14.entity.Food;
import com.wipro.assignment14.exception.ResourceNotFoundException;
import com.wipro.assignment14.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Get all foods
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // Get a single food by ID
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
    }

    // Save new food
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    // Delete food by ID
    public void deleteFood(Long id) {
        if (!foodRepository.existsById(id)) {
            throw new ResourceNotFoundException("Food not found with id: " + id);
        }
        foodRepository.deleteById(id);
    }
}

