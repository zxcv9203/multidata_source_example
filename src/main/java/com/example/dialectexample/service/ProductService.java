package com.example.dialectexample.service;

import com.example.dialectexample.domain.product.ProductRepository;
import com.example.dialectexample.domain.product.dto.ProductResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getProducts() {
        return productRepository.getProducts();
    }

    public ProductResponse getProductById(Long id) {
        return productRepository.getProductById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
    }
}
