package com.live.kitchen.pugz_live_kitchen.exception;

public class FoodNotAvailableException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    private Long quantity;

    public FoodNotAvailableException(String resourceName, String fieldName, Long fieldValue,Long quantity) {
        super(String.format("'%s' not available with '%s':'%s'.Available Quantity is '%s'", resourceName, fieldName, fieldValue,quantity));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
