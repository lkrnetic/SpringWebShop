package com.example.SpringBootWebShop.basket.basket_products;

import com.example.SpringBootWebShop.basket.Basket;
import com.example.SpringBootWebShop.order.Order;
import com.example.SpringBootWebShop.product.Product;

import javax.persistence.*;

@Table(name="product_of_basket")
@Entity
public class ProductOfBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "product_id"
    )
    private Basket basket;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "basket_id"
    )
    private Order order;
    private Integer quantity;
    private Double totalPrice;
}
