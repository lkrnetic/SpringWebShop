package com.example.SpringBootWebShop.basket.basket_product;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserServiceImpl;
import com.example.SpringBootWebShop.basket.Basket;
import com.example.SpringBootWebShop.basket.BasketServiceImpl;
import com.example.SpringBootWebShop.product.Product;
import com.example.SpringBootWebShop.product.ProductServiceImpl;
import com.example.SpringBootWebShop.review.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BasketProductServiceImpl {
    BasketServiceImpl basketServiceImpl;
    ProductServiceImpl productService;
    BasketProductRepository basketProductRepository;

    public BasketProduct createBasketProduct(BasketProductRequest request) {
        Basket basket = basketServiceImpl.getById(request.getBasketId());
        Product product = productService.getById(request.getProductId());
        BasketProduct basketProduct = new BasketProduct(product, basket, request.getQuantity());
        basketProductRepository.save(basketProduct);
        return basketProduct;
    }

    public BasketProduct updateBasketProduct(BasketProductRequest request, Long id) {
        basketProductRepository.updateBasketProduct(id, request.getQuantity());
        BasketProduct updatedBaskedProduct = basketProductRepository.getById(id);
        //updatedBaskedProduct.setQuantity(request.getQuantity());
        return updatedBaskedProduct;
    }

    public void deleteBasketProduct(Long id) {
        BasketProduct basketProduct = basketProductRepository.getById(id);
        basketProductRepository.delete(basketProduct);
    }

    public List<BasketProduct> getBasketProductsByBasket (Basket basket) {
        return  basketProductRepository.findByBasket(basket);
    }

    public BasketProduct getById(Long id) {
        return basketProductRepository.findById(id).orElse(null);
    }
}
