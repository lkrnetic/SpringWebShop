package com.example.SpringBootWebShop.product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product createProduct(ProductRequest request);
    Product editProduct(ProductRequest request, Long id);
    Product getById(Long id);
    void deleteProduct(Long id);
}