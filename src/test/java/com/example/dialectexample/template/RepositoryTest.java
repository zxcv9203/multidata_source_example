package com.example.dialectexample.template;

import com.example.dialectexample.config.QueryDslConfig;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Import({QueryDslConfig.class})
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = Replace.NONE)
public abstract class RepositoryTest {


    private static final DockerImageName MARIA_DB_VERSION = DockerImageName.parse(
        "mariadb:10.3.36");

    // static 으로 사용해야 1번만 초기화 (도커 올리고 내리는 과정이 시간이 걸리므로 1번만 하는 것이 좋을듯)
    @Container
    protected static final MariaDBContainer<?> mariadb = new MariaDBContainer<>(MARIA_DB_VERSION) // 지정하지 않으면 테이블 이름은 test
        .withInitScript("sql/data.sql");
    // .withInitScript를 통하여 값을 미리 준비해 둘 수 있음
    // 주의할점은 ddl-auto보다 해당 동작이 먼저 되기 때문에 테이블 생성부터 다해주어야함


    @DynamicPropertySource
    public static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariadb::getJdbcUrl);
        registry.add("spring.datasource.username", mariadb::getUsername);
        registry.add("spring.datasource.password", mariadb::getPassword);
        // jpa 설정 추가 가능 (Supplier를 전달해야하기 때문에 값을 추가하려면 함수를 하나 만들어야함)
        // 현재는 ddl-auto 예시임
//        registry.add("spring.jpa.hibernate.ddl-auto", RepositoryTest::ddlAuto);
    }

    private static String ddlAuto() {
        return "update";
    }
}
