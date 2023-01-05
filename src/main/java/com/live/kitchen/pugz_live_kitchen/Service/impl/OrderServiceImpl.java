package com.live.kitchen.pugz_live_kitchen.Service.impl;

import com.live.kitchen.pugz_live_kitchen.Service.OrderService;
import com.live.kitchen.pugz_live_kitchen.entity.Food;
import com.live.kitchen.pugz_live_kitchen.entity.Orders;
import com.live.kitchen.pugz_live_kitchen.exception.FoodAndQuantityMismatchExceptions;
import com.live.kitchen.pugz_live_kitchen.exception.FoodNotAvailableException;
import com.live.kitchen.pugz_live_kitchen.exception.ResourceNotFoundException;
import com.live.kitchen.pugz_live_kitchen.payload.OrderDto;
import com.live.kitchen.pugz_live_kitchen.repository.FoodRepository;
import com.live.kitchen.pugz_live_kitchen.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository, FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
    }
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Orders orders=mapToEntiy(orderDto);


        //Converting Strings to list
        List<Long> foodList = new ArrayList<>();
        for (String s : orderDto.getOrderList().split(","))
            foodList.add(Long.parseLong(s));
        List<Long> quantityList = new ArrayList<Long>();
        for (String s : orderDto.getQuantity().split(","))
            quantityList.add(Long.parseLong(s));

        //checking whether all foodIDs have respective quantity else throw an exception
        if(foodList.size()!=quantityList.size()) {
            throw new FoodAndQuantityMismatchExceptions();
        }

        //check whether the food is available in food table
        //check whether available Quantity is more than or equal to ordered quantity
        for(int i=0;i<foodList.size();i++){
            int finalI = i;
            Food food=foodRepository.findById(foodList.get(i)).orElseThrow(()->new ResourceNotFoundException("Food","ID",foodList.get(finalI)));
            if(food.getFoodQuantity()<quantityList.get(i)){
                throw new FoodNotAvailableException("Food","ID",foodList.get(finalI),food.getFoodQuantity());
            }
        }

        //Adding total amount and reducing quantity in food table for respective foodId
        long totalAmount=0;
        for(int i=0;i< foodList.size();i++)
        {
            int finalI = i;
            Food food=foodRepository.findById(foodList.get(i)).orElseThrow(()->new ResourceNotFoundException("Food","ID",foodList.get(finalI)));
            food.setFoodQuantity(food.getFoodQuantity() - quantityList.get(i));
            totalAmount+=quantityList.get(finalI)*food.getFoodPrice();
            foodRepository.save(food);
//            orders.setFood(food);
        }

        orders.setTotalAmount(totalAmount);
        orders.setQuantity(orderDto.getQuantity());
        orders.setOrderList(orderDto.getOrderList());
        Orders newOrder = orderRepository.save(orders);
        return mapToDto(newOrder);
    }

    private Orders mapToEntiy(OrderDto orderDto){
        Orders orders=new Orders();
        orders.setOrderId(orderDto.getOrderId());
        orders.setName(orderDto.getName());
        orders.setOrderList(orders.getOrderList());
        orders.setQuantity(orderDto.getQuantity());
        orders.setTotalAmount(orders.getTotalAmount());
        
        return orders;
    }
    
    private OrderDto mapToDto(Orders orders)
    {
        OrderDto orderDto=new OrderDto();
        orderDto.setOrderId(orders.getOrderId());
        orderDto.setName(orders.getName());
        orderDto.setOrderList(orders.getOrderList());
        orderDto.setQuantity(orders.getQuantity());
        orderDto.setTotalAmount(orders.getTotalAmount());

        return orderDto;
    }
}
