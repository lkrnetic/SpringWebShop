package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path="api/basket_products")
@AllArgsConstructor
public class BasketProductController {
    private final BasketProductServiceImpl basketProductServiceImpl;

    @PutMapping("/{id}")
    public BasketProduct editProduct(@RequestBody BasketProductRequest request, @PathVariable Long id) {
        return basketProductServiceImpl.updateBasketProduct(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        basketProductServiceImpl.deleteBasketProduct(id);
        return "deleted";
    }

    @PostMapping
    public BasketProduct createBasketProduct(@RequestBody BasketProductRequest request) {
        return basketProductServiceImpl.createBasketProduct(request);
    }
    /*
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productServiceImpl.getById(id);
    }
    */

}
