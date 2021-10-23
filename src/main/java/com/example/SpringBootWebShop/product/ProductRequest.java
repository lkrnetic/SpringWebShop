package com.example.SpringBootWebShop.product;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProductRequest {
    private Long userId;
    private String title;
    private String description;
    private Double price;
}
