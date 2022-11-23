package com.example.dialectexample.domain.product.dto;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateProductRequest {
    String name;

    BigDecimal price;
}
