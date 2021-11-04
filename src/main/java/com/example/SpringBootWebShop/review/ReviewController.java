package com.example.SpringBootWebShop.review;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="api/reviews")
@AllArgsConstructor
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @PutMapping("/{id}")
    public ResponseEntity<?> editReview(@RequestBody ReviewRequest request, @PathVariable Long id) {
        Review review = reviewService.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (review == null) {
            response.put("message", "Review with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            review = reviewService.editReview(request, id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Review was edited successfully.");
        response.put("review", review);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable Long id) {
        Review review = reviewService.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (review == null) {
            response.put("message", "Review with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            reviewService.deleteReview(id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Review was deleted successfully.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createReview(@RequestBody ReviewRequest request) {
        Review review = null;
        Map<String, Object> response = new HashMap<>();
        try {
            review = reviewService.createReview(request);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Review was created successfully.");
        response.put("review", review);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReview(@PathVariable Long id) {
        Review review = null;
        Map<String, Object> response = new HashMap<>();
        try {
            review = reviewService.getById(id);
        } catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (review == null) {
            response.put("message", "Review with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Review>(review, HttpStatus.OK);
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