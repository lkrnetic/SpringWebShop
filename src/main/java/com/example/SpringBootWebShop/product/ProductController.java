package com.example.SpringBootWebShop.product;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path="api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;
    @PutMapping("/{id}")
    public Product editProduct(@RequestBody ProductRequest request, @PathVariable Long id) {
        return productServiceImpl.editProduct(request, id);
    }

    @DeleteMapping("/{id}")
    public List<Product> deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteProduct(id);
        List<Product> products = productServiceImpl.getProducts();
        Collections.reverse(products);
        return products;
    }

    @PostMapping
    public Product createProduct(@RequestBody ProductRequest request) {
        return productServiceImpl.createProduct(request);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productServiceImpl.getById(id);
    }

    @GetMapping("/")
    public List<Product> getProducts() {
        List<Product> products = productServiceImpl.getProducts();
        Collections.reverse(products);
        return products;
    }


}
