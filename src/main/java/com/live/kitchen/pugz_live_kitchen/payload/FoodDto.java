package com.live.kitchen.pugz_live_kitchen.payload;

import lombok.Data;

@Data
public class FoodDto {
    private Long foodId;
    private String foodName;
    private Long foodPrice;
    private Long foodQuantity;
}
