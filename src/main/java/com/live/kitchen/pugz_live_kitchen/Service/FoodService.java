package com.live.kitchen.pugz_live_kitchen.Service;

import com.live.kitchen.pugz_live_kitchen.payload.FoodDto;

import java.util.List;

public interface FoodService {
    FoodDto addFood(FoodDto foodDto);
    List<FoodDto> getAllFood();

    FoodDto getFoodById(long id);

    FoodDto updateFoodById(FoodDto foodDto,long id);

    void deleteFoodById(long id);
}
