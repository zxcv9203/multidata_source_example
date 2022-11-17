package com.example.dialectexample.domain.product;

import com.example.dialectexample.domain.product.dto.ProductResponse;
import java.util.List;

public interface ProductCustomRepository {

    List<ProductResponse> getProducts();
}
