package com.example.dialectexample.domain.product;

import com.example.dialectexample.domain.product.dto.ProductResponse;
import com.example.dialectexample.template.RepositoryTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("ProductCustomRepositoryImpl 클래스의 ")
class ProductCustomRepositoryImplTest extends RepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Nested
    @DisplayName("getProducts 메서드는")
    class Describe_getProducts {

        @Nested
        @DisplayName("아무것도 전달하지 않으면")
        class Context_with_none {

            @Test
            @DisplayName("상품 리스트를 반환한다.")
            void it_returns_productResponse_list() {
                // given

                // when
                List<ProductResponse> products = productRepository.getProducts();
                // then
                products.forEach(System.out::println);
            }
        }
    }
}