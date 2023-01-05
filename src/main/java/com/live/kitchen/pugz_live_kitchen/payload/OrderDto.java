package com.live.kitchen.pugz_live_kitchen.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private long orderId;
    private String name;
    private String orderList;
    private String quantity;
    private long totalAmount;
}
