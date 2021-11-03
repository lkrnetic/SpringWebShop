package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getById(Long id);
}

