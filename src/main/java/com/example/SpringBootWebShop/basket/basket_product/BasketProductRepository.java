package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
    List<BasketProduct> findByBasket(Basket basket);
    @Transactional
    @Modifying
    @Query("UPDATE BasketProduct b " +
            "SET b.quantity = ?2 WHERE b.id = ?1")
    int updateBasketProduct(Long id, Integer quantity);

}
