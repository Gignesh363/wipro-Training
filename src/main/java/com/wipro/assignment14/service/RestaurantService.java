package com.wipro.assignment14.service;

import com.wipro.assignment14.entity.Restaurant;
import com.wipro.assignment14.entity.Food;
import com.wipro.assignment14.exception.ResourceNotFoundException;
import com.wipro.assignment14.repository.RestaurantRepository;
import com.wipro.assignment14.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, FoodRepository foodRepository) {
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: " + id));
    }

    public void deleteRestaurant(Long id) {
        if (!restaurantRepository.existsById(id)) {
            throw new ResourceNotFoundException("Restaurant not found with id: " + id);
        }
        restaurantRepository.deleteById(id);
    }

    public Food addFoodToRestaurant(Long restaurantId, Food food) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        food.setRestaurant(restaurant); // ✅ Works because Food.java has setRestaurant()
        return foodRepository.save(food);
    }

    public void deleteFood(Long foodId) {
        if (!foodRepository.existsById(foodId)) {
            throw new ResourceNotFoundException("Food not found with id: " + foodId);
        }
        foodRepository.deleteById(foodId);
    }
}
