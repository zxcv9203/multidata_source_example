package com.example.dialectexample.config.datasource;

import com.example.dialectexample.config.datasource.model.DataSourceType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class DistinctionRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ?
            DataSourceType.SLAVE : DataSourceType.MASTER;
    }
}
