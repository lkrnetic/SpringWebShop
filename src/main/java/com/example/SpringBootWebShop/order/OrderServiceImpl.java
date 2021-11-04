package com.example.SpringBootWebShop.order;

import com.example.SpringBootWebShop.appuser.AppUser;
import com.example.SpringBootWebShop.appuser.AppUserServiceImpl;
import com.example.SpringBootWebShop.basket.Basket;
import com.example.SpringBootWebShop.basket.BasketRepository;
import com.example.SpringBootWebShop.basket.BasketServiceImpl;
import com.example.SpringBootWebShop.basket.basket_product.BasketProduct;
import com.example.SpringBootWebShop.basket.basket_product.BasketProductRepository;
import com.example.SpringBootWebShop.basket.basket_product.BasketProductServiceImpl;
import com.example.SpringBootWebShop.order.order_product.OrderProduct;
import com.example.SpringBootWebShop.order.order_product.OrderProductRepository;
import com.example.SpringBootWebShop.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl {
    private final OrderRepository orderRepository;
    private final AppUserServiceImpl appUserService;
    private final BasketServiceImpl basketService;
    private final BasketProductServiceImpl basketProductService;
    private final BasketProductRepository basketProductRepository;
    private final OrderProductRepository orderProductRepository;

    public Order getById(Long id) {
        return orderRepository.findById(id).get();
    }

    public Order createOrder(OrderRequest request) {
        AppUser appUser = appUserService.getById(request.getUserId());
        Basket basket = basketService.getById(request.getBasketId());
        LocalDateTime localDateTime = LocalDateTime.now();
        Order order = new Order(appUser, localDateTime);
        Order savedOrder = orderRepository.save(order);
        List<BasketProduct> basketProducts = basketProductService.getBasketProductsByBasket(basket);
        List<OrderProduct> orderProducts = new ArrayList<>();;
        for(BasketProduct basketProduct: basketProducts) {
            Product product = basketProduct.getProduct();
            OrderProduct orderProduct = new OrderProduct(product, savedOrder, basketProduct.getQuantity());
            orderProduct = orderProductRepository.save(orderProduct);
            orderProducts.add(orderProduct);
            basketProductRepository.delete(basketProduct);
        }
        order = orderRepository.findById(savedOrder.getId()).get();
        order.setOrderProducts(orderProducts);
        return order;
    }

    public List<Order> getOrdersByUserId (AppUser appUser) {
        return orderRepository.findByAppUser(appUser);
    }

}
