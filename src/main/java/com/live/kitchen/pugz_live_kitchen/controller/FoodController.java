package com.live.kitchen.pugz_live_kitchen.controller;

import com.live.kitchen.pugz_live_kitchen.Service.FoodService;
import com.live.kitchen.pugz_live_kitchen.payload.FoodDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    private FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<FoodDto> addFood(@RequestBody FoodDto foodDto){
        return new ResponseEntity<>(foodService.addFood(foodDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<FoodDto> getAllFood()
    {
        return foodService.getAllFood();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable (name="id") long id)
    {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<FoodDto> updateFood(@RequestBody FoodDto foodDto,@PathVariable(name="id") long id)
    {
        return ResponseEntity.ok(foodService.updateFoodById(foodDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable(name="id") long id){
        foodService.deleteFoodById(id);
        return new ResponseEntity<>("Food is Deleted",HttpStatus.OK);
    }
}
