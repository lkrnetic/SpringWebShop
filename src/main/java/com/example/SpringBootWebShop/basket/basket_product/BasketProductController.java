package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductRequest;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import com.example.SpringBootWebShop.review.Review;
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
@RequestMapping(path="api/basket_products")
@AllArgsConstructor
public class BasketProductController {
    private final BasketProductServiceImpl basketProductServiceImpl;

    @PutMapping("/{id}")
    public ResponseEntity<?> editBasketProduct(@RequestBody BasketProductRequest request, @PathVariable Long id) {
        BasketProduct basketProduct = basketProductServiceImpl.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (basketProduct == null) {
            response.put("message", "Basket product with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            basketProduct = basketProductServiceImpl.updateBasketProduct(request, id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Basket product was edited successfully.");
        response.put("basketProduct", basketProduct);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBasketProduct(@PathVariable Long id) {
        BasketProduct basketProduct = basketProductServiceImpl.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (basketProduct == null) {
            response.put("message", "Basket product with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            basketProductServiceImpl.deleteBasketProduct(id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Basket product was deleted successfully.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> createBasketProduct(@RequestBody BasketProductRequest request) {
        BasketProduct basketProduct = null;
        Map<String, Object> response = new HashMap<>();
        try {
            basketProduct = basketProductServiceImpl.createBasketProduct(request);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Basket product was created successfully.");
        response.put("basketProduct", basketProduct);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


}
