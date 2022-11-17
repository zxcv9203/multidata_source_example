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

    @Container
    protected static final MariaDBContainer<?> mariadb = new MariaDBContainer<>(MARIA_DB_VERSION)
        .withInitScript("sql/data.sql");
//        .withDatabaseName("test");

    @DynamicPropertySource
    public static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariadb::getJdbcUrl);
        registry.add("spring.datasource.username", mariadb::getUsername);
        registry.add("spring.datasource.password", mariadb::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", RepositoryTest::ddlAuto);
    }

    private static String ddlAuto() {
        return "update";
    }
}
