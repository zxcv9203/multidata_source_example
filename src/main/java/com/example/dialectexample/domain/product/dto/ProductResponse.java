package com.example.dialectexample.domain.product.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.util.StringJoiner;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProductResponse {

    private Long id;

    private String name;

    private String price;

    @QueryProjection
    public ProductResponse(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProductResponse.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("price=" + price)
            .toString();
    }
}
