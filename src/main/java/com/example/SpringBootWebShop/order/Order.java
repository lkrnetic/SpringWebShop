package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "user_id"
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "product_id"
    )
    private Product product;
    private Double totalPrice;
    private Date createdAt;

    public Order() {

    }
}
