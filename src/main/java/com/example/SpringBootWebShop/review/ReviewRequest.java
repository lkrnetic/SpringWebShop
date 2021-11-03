package com.example.SpringBootWebShop.review;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ReviewRequest {
    private Long userId;
    private Long productId;
    private String text;
}
