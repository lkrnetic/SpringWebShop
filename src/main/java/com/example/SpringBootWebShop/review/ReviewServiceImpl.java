package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserServiceImpl;
import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    AppUserServiceImpl appUserService;
    ProductServiceImpl productService;
    ReviewRepository reviewRepository;

    @Override
    public Review createReview(ReviewRequest request) {
        AppUser appUser = appUserService.getById(request.getUserId());
        Product product = productService.getById(request.getProductId());
        LocalDateTime localDateTime = LocalDateTime.now();
        Review review = new Review(appUser, product, request.getText(), localDateTime);
        reviewRepository.save(review);
        return review;
    }

    @Override
    public Review editReview(ReviewRequest request, Long id) {
        Review review = getById(id);
        if (request.getText() != null) {
            review.setText(request.getText());
        }
        reviewRepository.update(review.getId(), request.getText());
        return review;
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.getById(id);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.getById(id);
        reviewRepository.delete(review);
    }
}
