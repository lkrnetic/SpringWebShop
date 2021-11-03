package com.example.SpringBootWebShop.product;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.review.Review;
import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Table(name="product")
@Entity
@ToString
public class Product  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;
    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;
    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    private String description;
    private Double price;
    private LocalDateTime createdAt;

    public Product() {

    }

    public Product(AppUser appUser, String title, String description, Double price, LocalDateTime createdAt) {
        this.appUser = appUser;
        this.title = title;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
