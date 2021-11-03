package com.example.SpringBootWebShop.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/orders")
@AllArgsConstructor
public class OrderController {
    OrderServiceImpl orderServiceImpl;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Order getOrders(@PathVariable Long id) {
        return orderServiceImpl.getById(id);
    }
}
