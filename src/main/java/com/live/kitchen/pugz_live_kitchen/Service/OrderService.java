package com.live.kitchen.pugz_live_kitchen.Service;

import com.live.kitchen.pugz_live_kitchen.payload.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
}
