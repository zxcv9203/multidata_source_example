package com.example.dialectexample.config.datasource;

import com.example.dialectexample.config.datasource.model.DataSourceType;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

@Configuration
public class RoutingDataSourceConfig {

    @Bean
    public DataSource routingDataSource(
        @Qualifier("masterDataSource") final DataSource masterDataSource,
        @Qualifier("slaveDataSource") final DataSource slaveDataSource
    ) {
        DistinctionRoutingDataSource routingDataSource = new DistinctionRoutingDataSource();

        Map<Object, Object> dataSourceMap = new HashMap<>();

        dataSourceMap.put(DataSourceType.MASTER, masterDataSource);
        dataSourceMap.put(DataSourceType.SLAVE, slaveDataSource);

        routingDataSource.setTargetDataSources(dataSourceMap);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);

        return routingDataSource;
    }

    @Bean
    public DataSource dataSource(
        @Qualifier("routingDataSource") DataSource routingDataSource
    ) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }
}
