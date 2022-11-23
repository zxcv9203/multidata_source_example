package com.example.dialectexample.service;

import com.example.dialectexample.domain.product.Product;
import com.example.dialectexample.domain.product.ProductRepository;
import com.example.dialectexample.domain.product.dto.CreateProductRequest;
import com.example.dialectexample.domain.product.dto.ProductResponse;
import com.example.dialectexample.domain.product.dto.UpdateProductRequest;
import java.util.List;
import java.util.Optional;
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

    public Long createProduct(CreateProductRequest request) {
        Product product = Product.builder()
            .name(request.getName())
            .price(request.getPrice())
            .build();
        return productRepository.save(product).getId();
    }

    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 ID의 상품은 존재하지 않습니다."));
        product.changeName(request.getName());
        product.changePrice(request.getPrice());

        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice().toPlainString())
            .build();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
