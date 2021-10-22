package com.example.SpringBootWebShop.order.order_products;

import com.example.SpringBootWebShop.order.Order;
import com.example.SpringBootWebShop.product.Product;

import javax.persistence.*;

@Table(name="product_of_order")
@Entity
public class ProductOfOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "product_id"
    )
    private Product product;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "order_id"
    )
    private Order order;
    private Integer quantity;
    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
