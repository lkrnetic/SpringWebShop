package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review getById(Long id);
    @Transactional
    @Modifying
    @Query("UPDATE Review r " +
            "SET r.text = ?2 WHERE r.id = ?1")
    int update(Long id, String text);
}
