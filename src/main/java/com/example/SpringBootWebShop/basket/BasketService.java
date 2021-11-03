package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.review.Review;
import com.example.SpringBootWebShop.review.ReviewRequest;

public interface BasketService {
    Basket getById(Long id);
    Basket createBasket(Long user_id);
}
