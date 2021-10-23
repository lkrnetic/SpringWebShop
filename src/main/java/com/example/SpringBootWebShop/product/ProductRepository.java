package com.example.SpringBootWebShop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getById(Long id);
    List<Product> findAll();
    @Transactional
    @Modifying
    @Query("UPDATE Product p " +
            "SET p.title = ?2, p.description = ?3, p.price = ?4 WHERE p.id = ?1")
    int update(Long id, String title, String description, Double price);

}