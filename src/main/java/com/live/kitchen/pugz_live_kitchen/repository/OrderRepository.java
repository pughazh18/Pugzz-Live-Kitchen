package com.live.kitchen.pugz_live_kitchen.repository;

import com.live.kitchen.pugz_live_kitchen.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
