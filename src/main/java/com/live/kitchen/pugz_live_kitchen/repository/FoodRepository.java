package com.live.kitchen.pugz_live_kitchen.repository;

import com.live.kitchen.pugz_live_kitchen.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long> {
}
