package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path="api/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @PutMapping("/{id}")
    public Review editReview(@RequestBody ReviewRequest request, @PathVariable Long id) {
        return reviewService.editReview(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "deleted";
    }

    @PostMapping
    public Review createReview(@RequestBody ReviewRequest request) {
        return reviewService.createReview(request);
    }

    @GetMapping("/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    /*
    @GetMapping("/")
    public List<Review> getReviews() {
        List<Review> reviews = reviewService.getReviews();
        Collections.reverse(reviews);
        return reviews;
    }
    */

}