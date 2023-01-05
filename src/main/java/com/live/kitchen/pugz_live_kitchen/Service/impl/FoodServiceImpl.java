package com.live.kitchen.pugz_live_kitchen.Service.impl;

import com.live.kitchen.pugz_live_kitchen.Service.FoodService;
import com.live.kitchen.pugz_live_kitchen.entity.Food;
import com.live.kitchen.pugz_live_kitchen.exception.ResourceNotFoundException;
import com.live.kitchen.pugz_live_kitchen.payload.FoodDto;
import com.live.kitchen.pugz_live_kitchen.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodDto addFood(FoodDto foodDto)
    {
        Food food=mapToEntity(foodDto);

        Food newFood=foodRepository.save(food);
        FoodDto foodResponse=mapToDto(newFood);
        return foodResponse;
    }

    @Override
    public List<FoodDto> getAllFood() {
        List<Food> foods=foodRepository.findAll();
        return foods.stream().map(food->mapToDto(food)).collect(Collectors.toList());
    }

    @Override
    public FoodDto getFoodById(long id) {
        Food food=foodRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Food","id",id));
        return mapToDto(food);
    }

    @Override
    public FoodDto updateFoodById(FoodDto foodDto, long id) {
        Food food= foodRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Food","id",id));
//        food.setFoodName(foodDto.getFoodName());
//        food.setFoodPrice(foodDto.getFoodPrice());
        food.setFoodQuantity(foodDto.getFoodQuantity());

        Food updatedFood=foodRepository.save(food);
        return mapToDto(updatedFood);
    }

    @Override
    public void deleteFoodById(long id) {
        Food food=foodRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Food","ID",id));
        foodRepository.delete(food);
    }

    private Food mapToEntity(FoodDto foodDto)
    {
        Food food=new Food();
        food.setFoodId(foodDto.getFoodId());
        food.setFoodName(foodDto.getFoodName());
        food.setFoodPrice(foodDto.getFoodPrice());
        food.setFoodQuantity(foodDto.getFoodQuantity());

        return food;
    }

    private FoodDto mapToDto(Food food)
    {
        FoodDto foodDto=new FoodDto();
        foodDto.setFoodId(food.getFoodId());
        foodDto.setFoodName(food.getFoodName());
        foodDto.setFoodPrice(food.getFoodPrice());
        foodDto.setFoodQuantity(food.getFoodQuantity());

        return foodDto;
    }
}
