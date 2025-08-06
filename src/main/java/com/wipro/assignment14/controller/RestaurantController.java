package com.wipro.assignment14.controller;

import com.wipro.assignment14.entity.Restaurant;
import com.wipro.assignment14.entity.Food;
import com.wipro.assignment14.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok("Restaurant deleted successfully");
    }

    @PostMapping("/{id}/foods")
    public ResponseEntity<Food> addFoodToRestaurant(@PathVariable Long id, @Valid @RequestBody Food food) {
        return new ResponseEntity<>(restaurantService.addFoodToRestaurant(id, food), HttpStatus.CREATED);
    }

    @DeleteMapping("/foods/{foodId}")
    public ResponseEntity<String> deleteFood(@PathVariable Long foodId) {
        restaurantService.deleteFood(foodId);
        return ResponseEntity.ok("Food deleted successfully");
    }
}
