package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.appuser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket getById(Long id);

}
