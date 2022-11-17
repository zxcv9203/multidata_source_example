package com.example.dialectexample.domain.product;

import com.example.dialectexample.domain.product.dto.ProductResponse;
import java.util.List;
import java.util.Optional;

public interface ProductCustomRepository {

    List<ProductResponse> getProducts();

    Optional<ProductResponse> getProductById(Long id);
}
