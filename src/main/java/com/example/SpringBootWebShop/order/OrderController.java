package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/orders")
@AllArgsConstructor
public class OrderController {
    OrderServiceImpl orderServiceImpl;
    AppUserRepository appUserRepository;

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public List<Order> getOrders(@PathVariable Long id) {
        AppUser appUser = appUserRepository.findById(id).get();
        return orderServiceImpl.getOrdersByUserId(appUser);
    }
}
