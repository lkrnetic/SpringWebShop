package com.example.SpringBootWebShop.basket.basket_product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BasketProductRequest {
    private Long basketId;
    private Long productId;
    private Integer quantity;

}
