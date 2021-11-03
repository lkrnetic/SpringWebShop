package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.basket.basket_product.BasketProduct;
import com.example.SpringBootWebShop.basket.basket_product.BasketProductRequest;
import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="order_of_products")
@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private LocalDateTime createdAt;

    public Order(AppUser user, LocalDateTime createdAt) {
        this.user = user;
        this.createdAt = createdAt;
    }
}
