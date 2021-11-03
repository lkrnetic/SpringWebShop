package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/basket")
@AllArgsConstructor
public class BasketController {
    BasketServiceImpl basketService;

    @PostMapping
    public Basket createProduct(@RequestBody BasketRequest request) {
        return basketService.createBasket(request.getUser_id());
    }
}
