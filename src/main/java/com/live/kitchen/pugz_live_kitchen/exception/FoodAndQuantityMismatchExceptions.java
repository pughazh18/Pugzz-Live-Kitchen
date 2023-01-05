package com.live.kitchen.pugz_live_kitchen.exception;

public class FoodAndQuantityMismatchExceptions extends RuntimeException {

    public FoodAndQuantityMismatchExceptions() {
        super(String.format("Make sure that all FoodId have Quantity and viceversa"));
    }
}