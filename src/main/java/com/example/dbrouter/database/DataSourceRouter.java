package com.example.dbrouter.database;

import com.example.dbrouter.context.DatabaseContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceRouter extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseContextHolder.get();
    }

}
