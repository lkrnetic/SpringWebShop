package com.example.SpringBootWebShop.product;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.SchemaOutputResolver;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    AppUserServiceImpl appUserService;
    ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        AppUser appUser = appUserService.getById(request.getUserId());
        LocalDateTime localDateTime = LocalDateTime.now();
        Product product = new Product(appUser, request.getTitle(), request.getDescription(), request.getPrice(), localDateTime);
        productRepository.save(product);
        return product;
    }

    @Override
    public Product editProduct(ProductRequest request, Long id) {
        Product product = getById(id);
        if (request.getTitle() != null) {
            product.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        productRepository.update(product.getId(), product.getTitle(), product.getDescription(), product.getPrice());
        return product;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getById(id);
        productRepository.delete(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
