package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;

public interface ReviewService {
    Review createReview(ReviewRequest request);
    Review editReview(ReviewRequest request, Long id);
    Review getById(Long id);
    void deleteReview(Long id);
}
