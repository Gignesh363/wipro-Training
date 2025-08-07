package com.myapp.producer.controller;

import com.myapp.producer.model.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return Arrays.asList(
            new Restaurant(1, "Spicy Hut", "Hyderabad"),
            new Restaurant(2, "Ocean View", "Visakhapatnam"),
            new Restaurant(3, "Tandoori Palace", "Delhi")
        );
    }
}
