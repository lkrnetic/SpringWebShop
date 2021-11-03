package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderService extends JpaRepository<Order, Long> {
    List<Order> getOrdersByUserId (AppUser appUser);
}
