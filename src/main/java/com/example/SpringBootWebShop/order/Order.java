package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.user.AppUser;

import javax.persistence.*;
import java.util.Date;
@Table(name="order_of_products")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser user;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
