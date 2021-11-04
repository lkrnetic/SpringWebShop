package com.example.SpringBootWebShop.product;

import com.example.SpringBootWebShop.appuser.AppUser;
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
@RequestMapping(path="api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @PutMapping("/{id}")
    public ResponseEntity<?> editProduct(@RequestBody ProductRequest request, @PathVariable Long id) {
        Product product = productServiceImpl.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (product == null) {
            response.put("message", "Product with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            product = productServiceImpl.editProduct(request, id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Product was edited successfully.");
        response.put("product", product);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Product product = productServiceImpl.getById(id);
        Map<String, Object> response = new HashMap<>();
        if (product == null) {
            response.put("message", "Product with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            productServiceImpl.deleteProduct(id);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Product was deleted successfully.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        Product product = null;
        Map<String, Object> response = new HashMap<>();
        try {
            product = productServiceImpl.createProduct(request);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Product was created successfully.");
        response.put("product", product);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        Product product = null;
        Map<String, Object> response = new HashMap<>();
        try {
            product = productServiceImpl.getById(id);
        } catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (product == null) {
            response.put("message", "Product with ID: ".concat(id.toString().concat(" doesn't exist in database.")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getProducts() {
        Map<String, Object> response = new HashMap<>();
        List<Product> products = null;
        try {
             products = productServiceImpl.getProducts();
             Collections.reverse(products);
             response.put("products", products);
        }
        catch (DataAccessException e)  {
            response.put("message", "Error with database query.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
