package com.myapp.consumer.controller;

import com.myapp.consumer.model.Restaurant;
import com.myapp.consumer.service.RestaurantFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    private final RestaurantFeignClient restaurantFeignClient;

    public ConsumerController(RestaurantFeignClient restaurantFeignClient) {
        this.restaurantFeignClient = restaurantFeignClient;
    }

    @GetMapping("/consumer/restaurants")
    public List<Restaurant> getRestaurantsFromProducer() {
        return restaurantFeignClient.getRestaurants();
    }
}
