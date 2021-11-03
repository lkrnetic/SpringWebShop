package com.example.SpringBootWebShop.order.order_product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository  extends JpaRepository<OrderProduct, Long> {
    OrderProduct getById(Long id);
}
