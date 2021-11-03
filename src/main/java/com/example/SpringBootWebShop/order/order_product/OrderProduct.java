package com.example.SpringBootWebShop.order.order_product;

import com.example.SpringBootWebShop.order.Order;
import com.example.SpringBootWebShop.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="product_of_order")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "product_id"
    )
    private Product product;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "order_id"
    )
    private Order order;
    private Integer quantity;

    public OrderProduct(Product product, Order order, Integer quantity) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }
}
