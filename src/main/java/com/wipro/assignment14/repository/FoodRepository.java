package com.wipro.assignment14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.assignment14.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
