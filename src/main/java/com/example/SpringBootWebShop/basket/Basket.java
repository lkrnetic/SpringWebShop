package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.basket.basket_product.BasketProduct;
import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.review.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="basket")
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonBackReference
    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;
    @JsonManagedReference
    @OneToMany(mappedBy = "basket")
    private List<BasketProduct> basketProducts;

    public Basket(AppUser appUser) {
        this.appUser = appUser;
    }
}
