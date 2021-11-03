package com.example.SpringBootWebShop.basket;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.appuser.AppUser;

import javax.persistence.*;

@Table(name="basket")
@Entity
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    public Basket() {

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

    public Basket(AppUser appUser) {
        this.appUser = appUser;
    }
}
