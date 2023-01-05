package com.live.kitchen.pugz_live_kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )
    private long orderId;

    private String name;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "food_id",nullable = false)
//    private Food food;


    private String orderList;

    private String quantity;
    private long totalAmount;
}
