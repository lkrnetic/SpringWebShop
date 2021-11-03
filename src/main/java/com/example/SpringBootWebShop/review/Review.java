package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="review")
@Entity
public class Review  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )

    private AppUser user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "product_id"
    )
    private Product product;

    @Column(
            name = "text",
            columnDefinition = "TEXT"
    )
    private String text;
    private LocalDateTime createdAt;

    public Review() {

    }

    public Review(AppUser user, Product product, String text, LocalDateTime createdAt) {
        this.user = user;
        this.product = product;
        this.text = text;
        this.createdAt = createdAt;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
