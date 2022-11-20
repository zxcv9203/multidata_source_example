package com.example.dialectexample.config.flyway;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig {

    private final DataSource slaveDataSource;

    public FlywayConfig(
        @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        this.slaveDataSource = slaveDataSource;
    }

    @PostConstruct
    public void runMigration() {
        Flyway.configure()
            .dataSource(slaveDataSource)
            .locations("db/migration")
            .baselineOnMigrate(true)
            .load()
            .migrate();
    }
}
