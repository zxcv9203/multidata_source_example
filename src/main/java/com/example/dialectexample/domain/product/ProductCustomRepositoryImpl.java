package com.example.dialectexample.domain.product;

import static com.example.dialectexample.domain.product.QProduct.product;
import com.example.dialectexample.domain.product.dto.ProductResponse;
import com.example.dialectexample.domain.product.dto.QProductResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductCustomRepositoryImpl implements
    ProductCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ProductResponse> getProducts() {
        return jpaQueryFactory.select(
                new QProductResponse(product.id, product.name, product.price)
            )
            .from(product)
            .fetch();
    }
}
