package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.basket.Basket;
import com.example.SpringBootWebShop.order.Order;
import com.example.SpringBootWebShop.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name="product_of_basket")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
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
            name = "basket_id"
    )
    private Basket basket;
    private Integer quantity;

    public BasketProduct(Product product, Basket basket, Integer quantity) {
        this.product = product;
        this.basket = basket;
        this.quantity = quantity;
    }
}
