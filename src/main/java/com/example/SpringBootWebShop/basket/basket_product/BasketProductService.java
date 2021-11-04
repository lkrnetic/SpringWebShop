package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.basket.Basket;

import java.util.List;

public interface BasketProductService {
    BasketProduct createBasketProduct(BasketProductRequest request);
    BasketProduct updateBasketProduct(BasketProductRequest request, Long id);
    void deleteBasketProduct(Long id);
    List<BasketProduct> getBasketProductsByBasket (Basket basket);
    BasketProduct getById(Long id);
}
